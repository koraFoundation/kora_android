package com.kora.android.presentation.ui.main.fragments.send;

import com.kora.android.di.annotation.ConfigPersistent;
import com.kora.android.presentation.ui.base.presenter.BasePresenter;

import javax.inject.Inject;

@ConfigPersistent
public class SendPresenter extends BasePresenter<SendView> {

    @Inject
    public SendPresenter() {

    }
}
