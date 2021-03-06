package com.kora.android.di.component;

import android.content.Context;

import com.kora.android.KoraApplication;
import com.kora.android.common.helper.RegistrationPrefHelper;
import com.kora.android.common.preferences.PreferenceHandler;
import com.kora.android.data.repository.AuthRepository;
import com.kora.android.data.repository.BorrowRepository;
import com.kora.android.data.repository.CurrencyConvertRepository;
import com.kora.android.data.repository.DepositWithdrawRepository;
import com.kora.android.data.repository.RequestRepository;
import com.kora.android.data.repository.TransactionRepository;
import com.kora.android.data.repository.UserRepository;
import com.kora.android.data.repository.Web3jRepository;
import com.kora.android.data.web3j.connection.Web3jConnection;
import com.kora.android.data.web3j.storage.EtherWalletStorage;
import com.kora.android.data.web3j.utils.EtherWalletUtils;
import com.kora.android.di.module.ApplicationModule;
import com.kora.android.di.module.NetworkModule;
import com.kora.android.di.module.RepositoryModule;
import com.kora.android.di.module.ServiceModule;
import com.kora.android.di.module.Web3jModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ServiceModule.class,
        NetworkModule.class,
        RepositoryModule.class,
        Web3jModule.class
})
public interface ApplicationComponent {

    void inject(final KoraApplication application);

    Context context();

    PreferenceHandler preferanceHandler();
    RegistrationPrefHelper registrationPrefHelper();

    EtherWalletUtils etherWalletUtils();
    EtherWalletStorage etherWalletStorage();
    Web3jConnection web3jConnection();

    AuthRepository authRepository();
    UserRepository userRepository();
    CurrencyConvertRepository currencyConverterRepository();
    TransactionRepository transactionRepository();
    RequestRepository requestRepository();
    BorrowRepository borrowRepository();
    DepositWithdrawRepository depositRepository();
    Web3jRepository walletRepository();
}
