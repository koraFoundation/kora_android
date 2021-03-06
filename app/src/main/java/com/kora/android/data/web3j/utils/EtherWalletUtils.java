package com.kora.android.data.web3j.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.ObjectMapperFactory;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static com.kora.android.common.Keys.ADDRESS_PREFIX;
import static com.kora.android.common.Keys.JSON_FILE_EXTENSION;

public class EtherWalletUtils {

    // methods are taken from original class org.web3j.crypto.WalletUtils to change getWalletFileName(WalletFile walletFile)

    public String generateNewWalletFile(
            final String password, final File destinationDirectory)
            throws CipherException, IOException, InvalidAlgorithmParameterException,
            NoSuchAlgorithmException, NoSuchProviderException {
        return generateNewWalletFile(password, destinationDirectory, true);
    }

    public String generateNewWalletFile(
            String password, File destinationDirectory, boolean useFullScrypt)
            throws CipherException, IOException, InvalidAlgorithmParameterException,
            NoSuchAlgorithmException, NoSuchProviderException {

        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        return generateWalletFile(password, ecKeyPair, destinationDirectory, useFullScrypt);
    }

    public String generateWalletFile(
            String password, ECKeyPair ecKeyPair, File destinationDirectory)
            throws CipherException, IOException {
        return generateWalletFile(password, ecKeyPair, destinationDirectory, true);
    }

    public String generateWalletFile(
            String password, ECKeyPair ecKeyPair, File destinationDirectory, boolean useFullScrypt)
            throws CipherException, IOException {

        WalletFile walletFile;
        if (useFullScrypt) {
            walletFile = Wallet.createStandard(password, ecKeyPair);
        } else {
            walletFile = Wallet.createLight(password, ecKeyPair);
        }

        String fileName = getWalletFileName(walletFile);
        File destination = new File(destinationDirectory, fileName);

        ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper();
        objectMapper.writeValue(destination, walletFile);

        return fileName;
    }

    private String getWalletFileName(WalletFile walletFile) {
        return ADDRESS_PREFIX + walletFile.getAddress() + JSON_FILE_EXTENSION;
    }
}