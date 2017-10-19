package com.kora.android.presentation.ui.send.enter_pin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

import com.kora.android.R;
import com.kora.android.common.Keys;
import com.kora.android.di.component.ActivityComponent;
import com.kora.android.presentation.model.UserEntity;
import com.kora.android.presentation.ui.base.view.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

import static com.kora.android.common.Keys.Args.RECEIVER_AMOUNT;
import static com.kora.android.common.Keys.Args.SENDER_AMOUNT;
import static com.kora.android.common.Keys.Args.USER_ENTITY;

public class EnterPinActivity extends BaseActivity<EnterPinPresenter> implements EnterPinView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.edit_layout_enter_pin)
    TextInputLayout mElCreatePinCode;
    @BindView(R.id.edit_text_pin_first_digit)
    TextInputEditText mEtPinFirstDigit;
    @BindView(R.id.edit_text_pin_second_digit)
    TextInputEditText mEtPinSecondDigit;
    @BindView(R.id.edit_text_pin_third_digit)
    TextInputEditText mEtPinThirdDigit;
    @BindView(R.id.edit_text_pin_fourth_digit)
    TextInputEditText mEtPinFourthDigit;

    public static Intent getLaunchIntent(final BaseActivity baseActivity,
                                         final UserEntity userEntity,
                                         final double senderAmount,
                                         final double receiverAmount) {
        final Intent intent = new Intent(baseActivity, EnterPinActivity.class);
        intent.putExtra(USER_ENTITY, userEntity);
        intent.putExtra(SENDER_AMOUNT, senderAmount);
        intent.putExtra(RECEIVER_AMOUNT, receiverAmount);
        return intent;
    }

    @Override
    public void injectToComponent(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_enter_pin;
    }


    @Override
    protected void onViewReady(final Bundle savedInstanceState) {
        setToolbar(mToolbar, R.drawable.ic_back_white);

        initArguments();
    }

    private void initArguments() {
        if (getIntent() != null) {
                getPresenter().setUserEntity(getIntent().getParcelableExtra(USER_ENTITY));
                getPresenter().setSenderAmount(getIntent().getDoubleExtra(SENDER_AMOUNT, 0));
                getPresenter().setReceiverAmount(getIntent().getDoubleExtra(RECEIVER_AMOUNT, 0));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(USER_ENTITY, getPresenter().getUserEntity());
        outState.putDouble(SENDER_AMOUNT, getPresenter().getSenderAmount());
        outState.putDouble(RECEIVER_AMOUNT, getPresenter().getReceiverAmount());
    }

    @OnTextChanged({
            R.id.edit_text_pin_first_digit,
            R.id.edit_text_pin_second_digit,
            R.id.edit_text_pin_third_digit,
            R.id.edit_text_pin_fourth_digit
    })
    public void onChangedPinCode() {
        mElCreatePinCode.setError(null);
    }

    @Override
    public void showEmptyPinCode() {
        mElCreatePinCode.setError(getString(R.string.enter_pin_pin_empty));
    }

    @Override
    public void showTooShortPinCode() {
        mElCreatePinCode.setError(getString(R.string.enter_pin_pin_too_short));
    }

    @OnClick(R.id.card_view_finish)
    public void onClickFinish() {
        final String pinCode =
                        mEtPinFirstDigit.getText().toString() +
                        mEtPinSecondDigit.getText().toString() +
                        mEtPinThirdDigit.getText().toString() +
                        mEtPinFourthDigit.getText().toString();
        getPresenter().startSendTransactionTask(pinCode);
    }
}
