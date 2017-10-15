package com.kora.android.presentation.ui.main.fragments.request;

import com.kora.android.di.annotation.ConfigPersistent;
import com.kora.android.presentation.ui.base.presenter.BasePresenter;

import javax.inject.Inject;

@ConfigPersistent
public class RequestPresenter extends BasePresenter<RequestView> {

    @Inject
    public RequestPresenter() {

    }
}
