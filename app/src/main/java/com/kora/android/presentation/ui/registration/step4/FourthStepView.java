package com.kora.android.presentation.ui.registration.step4;

import com.kora.android.presentation.model.Country;
import com.kora.android.presentation.ui.base.view.BaseView;

import java.io.File;

public interface FourthStepView extends BaseView<FourthStepPresenter> {

    void showCurrency(final Country country);

    void showAvatar(final File file);

    void showEmptyUserName();
    void showIncorrectUserName();
    void showTooShortUserName();

    void showIncorrectEmail();

    void showEmptyPassword();
    void showTooShortPassword();

    void showEmptyConfirmPassword();
    void showIncorrectConfirmPassword();

    void showNextScreen();
    void showServerErrorValidation(final String message);
}