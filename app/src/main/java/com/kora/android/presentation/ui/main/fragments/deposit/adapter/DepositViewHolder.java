package com.kora.android.presentation.ui.main.fragments.deposit.adapter;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kora.android.R;
import com.kora.android.common.utils.DateUtils;
import com.kora.android.presentation.enums.DepositState;
import com.kora.android.presentation.model.DepositEntity;
import com.kora.android.presentation.ui.base.adapter.OnItemClickListener;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DepositViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.direction_icon)
    ImageView mDirectionIcon;
    @BindView(R.id.sender_name)
    TextView mSenderName;
    @BindView(R.id.request_name)
    TextView mRequestName;
    @BindView(R.id.date)
    TextView mDate;
    @BindView(R.id.time)
    TextView mTime;
    @BindView(R.id.amount)
    TextView mAmount;
    @BindView(R.id.status)
    TextView mState;

    private OnItemClickListener mOnItemClickListener;
    private Context mContext;

    private DecimalFormat mFormatter;

    public DepositViewHolder(final View itemView, @Nullable final OnItemClickListener onItemClickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mOnItemClickListener = onItemClickListener;
        mFormatter = new DecimalFormat("#,###,###,##0.00");
    }

    public void bind(final DepositEntity depositEntity) {
        switch (depositEntity.getDirection()) {
            case FROM:
                mDirectionIcon.setImageResource(R.drawable.ic_arrow_red);
                mSenderName.setText(R.string.request_money_from_my_label);
                mAmount.setText(mContext.getString(R.string.transactions_amount, mFormatter.format(depositEntity.getFromAmount()), depositEntity.getFrom().getCurrency()));
                mRequestName.setText(mContext.getString(R.string.request_money_ask_money_label, depositEntity.getTo().getFullName()));
                break;
            case TO:
                mDirectionIcon.setImageResource(R.drawable.ic_arrow_green);
                mSenderName.setText(mContext.getString(R.string.request_money_from_label, depositEntity.getFrom().getFullName()));
                mAmount.setText(mContext.getString(R.string.transactions_amount, mFormatter.format(depositEntity.getToAmount()), depositEntity.getTo().getCurrency()));
                mRequestName.setText(R.string.request_money_ask_to_me);
                break;
        }
        showStatus(depositEntity.getState());

        mDate.setText(DateUtils.getFormattedDate("dd.MM.yyyy", depositEntity.getCreatedAt()));
        mTime.setText(DateUtils.getFormattedDate("hh:mm aa", depositEntity.getCreatedAt()));
    }

    private void showStatus(final DepositState state) {
        switch (state) {
            case INPROGRESS:
                mState.setText(R.string.request_money_status_in_progress);
                mState.setTextColor(mContext.getResources().getColor(R.color.color_state_positive));
                break;

            case REJECTED:
                mState.setText(R.string.request_money_status_rejected);
                mState.setTextColor(mContext.getResources().getColor(R.color.color_state_negative));
                break;
        }
    }

    @OnClick(R.id.root_view)
    public void onItemClicked() {
        if (mOnItemClickListener == null) return;
        mOnItemClickListener.onItemClicked(getAdapterPosition());
    }
}
