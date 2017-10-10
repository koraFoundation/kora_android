package com.kora.android.presentation.ui.splash;

import android.os.Bundle;

import com.kora.android.R;
import com.kora.android.injection.component.ActivityComponent;
import com.kora.android.presentation.ui.base.view.BaseActivity;
import com.kora.android.presentation.ui.main.MainActivity;
import com.kora.android.presentation.ui.registration.step1.FirstStepActivity;
import com.kora.android.presentation.ui.registration.step3.ThirdStepActivity;
import com.kora.android.presentation.ui.registration.step3.ThirdStepView;
import com.kora.android.presentation.ui.registration.step4.FourthStepActivity;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashView {

    @Override
    public void injectToComponent(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewReady(final Bundle savedInstanceState) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().startSplashTask();
    }

    @Override
    public void showNextScreen(final boolean isSessionTokenEmpty) {
//        if (isSessionTokenEmpty)
//            startActivity(WelcomeActivity.getLaunchIntent(this));
//        else
//        startActivity(MainActivity.getLaunchIntent(this));

        startActivity(FirstStepActivity.getLaunchIntent(this));

//        startActivity(ThirdStepActivity.getLaunchIntent(this));

//        startActivity(FourthStepActivity.getLaunchIntent(this));
    }
}
