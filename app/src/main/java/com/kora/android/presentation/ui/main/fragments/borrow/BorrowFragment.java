package com.kora.android.presentation.ui.main.fragments.borrow;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.kora.android.R;
import com.kora.android.di.component.FragmentComponent;
import com.kora.android.presentation.ui.base.backstack.StackFragment;
import com.kora.android.presentation.ui.base.view.BaseFragment;

import butterknife.BindView;

public class BorrowFragment extends StackFragment<BorrowPresenter> implements BorrowView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static BaseFragment getNewInstance() {
        return new BorrowFragment();
    }

    @Override
    public void injectToComponent(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_borrow;
    }

    @Override
    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected void onViewReady(final Bundle savedInstanceState) {

    }
}