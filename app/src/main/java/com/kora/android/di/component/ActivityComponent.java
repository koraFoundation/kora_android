package com.kora.android.di.component;

import com.kora.android.di.annotation.PerActivity;
import com.kora.android.di.module.ActivityModule;
import com.kora.android.presentation.ui.borrow.BorrowMoneyActivity;
import com.kora.android.presentation.ui.coming_soon.ComingSoonActivity;
import com.kora.android.presentation.ui.common.add_contact.GetContactActivity;
import com.kora.android.presentation.ui.common.deposit_withdraw.DepositWithdrawDetailsActivity;
import com.kora.android.presentation.ui.common.enter_pin.EnterPinActivity;
import com.kora.android.presentation.ui.common.send_request.RequestDetailsActivity;
import com.kora.android.presentation.ui.login.LoginActivity;
import com.kora.android.presentation.ui.main.MainActivity;
import com.kora.android.presentation.ui.registration.countries.CountriesActivity;
import com.kora.android.presentation.ui.registration.currencies.CurrenciesActivity;
import com.kora.android.presentation.ui.registration.step1.FirstStepActivity;
import com.kora.android.presentation.ui.registration.step2.SecondStepActivity;
import com.kora.android.presentation.ui.registration.step3.ThirdStepActivity;
import com.kora.android.presentation.ui.registration.step4.FourthStepActivity;
import com.kora.android.presentation.ui.splash.SplashActivity;
import com.kora.android.presentation.ui.test.TestActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);
    void inject(TestActivity testActivity);

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
    void inject(RequestDetailsActivity requestDetailsActivity);

    void inject(BorrowMoneyActivity borrowMoneyActivity);

    void inject(ComingSoonActivity comingSoonActivity);

    void inject(DepositWithdrawDetailsActivity depositWithdrawDetailsActivity);
}
