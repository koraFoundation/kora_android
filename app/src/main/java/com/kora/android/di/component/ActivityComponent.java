package com.kora.android.di.component;

import com.kora.android.di.annotation.PerActivity;
import com.kora.android.di.module.ActivityModule;
import com.kora.android.presentation.ui.borrow.BorrowMoneyActivity;
import com.kora.android.presentation.ui.coming_soon.ComingSoonActivity;
import com.kora.android.presentation.ui.get_contact.GetContactActivity;
import com.kora.android.presentation.ui.deposit_withdraw.DepositWithdrawDetailsActivity;
import com.kora.android.presentation.ui.enter_pin.EnterPinActivity;
import com.kora.android.presentation.ui.send_request.SendRequestDetailsActivity;
import com.kora.android.presentation.ui.forgot_password.step1.ForgotPassword1Activity;
import com.kora.android.presentation.ui.forgot_password.step2.ForgotPassword2Activity;
import com.kora.android.presentation.ui.login.LoginActivity;
import com.kora.android.presentation.ui.main.MainActivity;
import com.kora.android.presentation.ui.registration.countries.CountriesActivity;
import com.kora.android.presentation.ui.registration.currencies.CurrenciesActivity;
import com.kora.android.presentation.ui.registration.step1.FirstStepActivity;
import com.kora.android.presentation.ui.registration.step2.SecondStepActivity;
import com.kora.android.presentation.ui.registration.step3.ThirdStepActivity;
import com.kora.android.presentation.ui.registration.step4.FourthStepActivity;
import com.kora.android.presentation.ui.splash.SplashActivity;
import com.kora.android.presentation.ui.transactions.TransactionDetailsActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(FirstStepActivity firstStepActivity);
    void inject(SecondStepActivity secondStepActivity);
    void inject(ThirdStepActivity thirdStepActivity);
    void inject(FourthStepActivity fourthStepActivity);

    void inject(CountriesActivity countriesActivity);
    void inject(CurrenciesActivity currenciesActivity);

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(GetContactActivity getContactActivity);
    void inject(EnterPinActivity enterPinActivity);
    void inject(SendRequestDetailsActivity sendRequestDetailsActivity);

    void inject(BorrowMoneyActivity borrowMoneyActivity);

    void inject(ComingSoonActivity comingSoonActivity);

    void inject(DepositWithdrawDetailsActivity depositWithdrawDetailsActivity);

    void inject(ForgotPassword1Activity forgotPassword1Activity);
    void inject(ForgotPassword2Activity forgotPassword2Activity);

    void inject(TransactionDetailsActivity transactionDetailsActivity);
}
