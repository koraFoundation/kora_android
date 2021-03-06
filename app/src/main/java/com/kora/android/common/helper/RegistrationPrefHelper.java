package com.kora.android.common.helper;

import android.content.Context;

import com.google.gson.Gson;
import com.kora.android.presentation.model.CountryEntity;
import com.pddstudio.preferences.encrypted.EncryptedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.kora.android.common.Keys.RegistrationHelperKeys.REGISTRATION_HELPER_COUNTRY;
import static com.kora.android.common.Keys.RegistrationHelperKeys.REGISTRATION_HELPER_FILE_NAME;
import static com.kora.android.common.Keys.RegistrationHelperKeys.REGISTRATION_HELPER_FILE_PASSWORD;
import static com.kora.android.common.Keys.RegistrationHelperKeys.REGISTRATION_HELPER_PHONE_NUMBER;
import static com.kora.android.common.Keys.RegistrationHelperKeys.REGISTRATION_HELPER_PIN_CODE;

@Singleton
public class RegistrationPrefHelper {

    private final EncryptedPreferences mEncryptedPreferences;

    @Inject
    public RegistrationPrefHelper(final Context context) {
        mEncryptedPreferences = new EncryptedPreferences.Builder(context)
                .withPreferenceName(REGISTRATION_HELPER_FILE_NAME)
                .withEncryptionPassword(REGISTRATION_HELPER_FILE_PASSWORD)
                .build();
    }

    public void storeCountry(final CountryEntity countryEntity) {
        final String countryString = new Gson().toJson(countryEntity);
        mEncryptedPreferences.edit().putString(REGISTRATION_HELPER_COUNTRY, countryString).apply();
    }

    public CountryEntity getCountry() {
        final String countryString = mEncryptedPreferences.getString(REGISTRATION_HELPER_COUNTRY, "");
        return new Gson().fromJson(countryString, CountryEntity.class);
    }

    public void storePhoneNumber(final String phoneNumber) {
        mEncryptedPreferences.edit().putString(REGISTRATION_HELPER_PHONE_NUMBER, phoneNumber).apply();
    }

    public String getPhoneNumber() {
        return mEncryptedPreferences.getString(REGISTRATION_HELPER_PHONE_NUMBER, "");
    }

    public void clear() {
        mEncryptedPreferences.edit().clear().apply();
    }

    public String getPinCode() {
        return mEncryptedPreferences.getString(REGISTRATION_HELPER_PIN_CODE, "");
    }

    public void storePin(String pinCode) {
        mEncryptedPreferences.edit().putString(REGISTRATION_HELPER_PIN_CODE, pinCode).apply();
    }
}
