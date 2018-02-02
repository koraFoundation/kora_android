package com.kora.android.presentation.ui.forgot_password.step2;

import com.kora.android.common.utils.StringUtils;
import com.kora.android.data.network.config.ErrorModel;
import com.kora.android.data.network.exception.RetrofitException;
import com.kora.android.di.annotation.ConfigPersistent;
import com.kora.android.domain.base.DefaultInternetSubscriber;
import com.kora.android.domain.usecase.user.RestorePasswordUseCase;
import com.kora.android.presentation.ui.base.custom.RetryAction;
import com.kora.android.presentation.ui.base.presenter.BasePresenter;

import javax.inject.Inject;

import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableObserver;

@ConfigPersistent
public class ForgotPassword2Presenter extends BasePresenter<ForgotPassword2View> {

    private final RestorePasswordUseCase mRestorePasswordUseCase;

    private String mToken;
    private String mNewPassword;
    private String mConfirmPassword;

    @Inject
    public ForgotPassword2Presenter(final RestorePasswordUseCase restorePasswordUseCase) {
        mRestorePasswordUseCase = restorePasswordUseCase;
    }

    public void setToken(final String token) {
        mToken = token;
    }

    public void setNewPassword(final String newPassword) {
        mNewPassword = newPassword;
    }

    public void setConfirmPassword(final String confirmPassword) {
        mConfirmPassword = confirmPassword;
    }

    public void confirmPassword() {
        if (mToken == null || mToken.isEmpty()) {
            getView().showEmptyToken();
            return;
        }
        if (mNewPassword == null || mNewPassword.isEmpty()) {
            getView().showEmptyNewPassword();
            return;
        }
        if (!StringUtils.isPasswordValid(mNewPassword)) {
            getView().showIncorrectNewPassword();
            return;
        }
        if (mConfirmPassword == null || mConfirmPassword.isEmpty()) {
            getView().showEmptyConfirmPassword();
            return;
        }
        if (!mNewPassword.equals(mConfirmPassword)) {
            getView().showIncorrectConfirmPassword();
            return;
        }

        mRestorePasswordUseCase.setData(mToken, mNewPassword);
        mRestorePasswordUseCase.execute(new RestorePasswordSubscriber());
    }

    private Action mRestorePasswordAction = new Action() {
        @Override
        public void run() throws Exception {
            mRestorePasswordUseCase.execute(new RestorePasswordSubscriber());
        }
    };

    private class RestorePasswordSubscriber extends DefaultInternetSubscriber {

        @Override
        protected void onStart() {
            if (!isViewAttached()) return;
            getView().showProgress(true);
        }

        @Override
        public void onComplete() {
            if (!isViewAttached()) return;
            getView().showProgress(true);
            getView().showHomeScreen();
        }

        @Override
        public void onError(final Throwable throwable) {
            super.onError(throwable);
            if (!isViewAttached()) return;
            getView().showProgress(false);
        }

        @Override
        public void handleUnprocessableEntity(final ErrorModel errorModel) {
            if (!isViewAttached()) return;
            getView().showError(errorModel.getError());
        }

        @Override
        public void handleNetworkError(final RetrofitException retrofitException) {
            if (!isViewAttached()) return;
            getView().showErrorWithRetry(new RetryAction(mRestorePasswordAction));
        }
    }

    @Override
    public void onDetachView() {
        mRestorePasswordUseCase.dispose();
    }
}
