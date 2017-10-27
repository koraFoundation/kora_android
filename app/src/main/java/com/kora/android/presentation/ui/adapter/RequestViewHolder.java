package com.kora.android.presentation.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kora.android.R;
import com.kora.android.common.utils.DateUtils;
import com.kora.android.presentation.enums.TransactionType;
import com.kora.android.presentation.model.TransactionEntity;
import com.kora.android.presentation.ui.base.adapter.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public final class RequestViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.direction_icon) ImageView mDirectionIcon;
    @BindView(R.id.sender_name) TextView mSenderName;
    @BindView(R.id.receiver_name) TextView mReceiverName;
    @BindView(R.id.date) TextView mDate;
    @BindView(R.id.type) TextView mType;
    @BindView(R.id.amount) TextView mAmount;

    private OnItemClickListener mOnItemClickListener;

    private Context mContext;
    private Unbinder mUnbinder;


    public RequestViewHolder(View itemView, @Nullable OnItemClickListener onItemClickListener) {
        super(itemView);
        mUnbinder = ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mOnItemClickListener = onItemClickListener;
    }

    public void bind(TransactionEntity transactionEntity) {
        switch (transactionEntity.getDirection()) {
            case FROM:
                mDirectionIcon.setImageResource(R.drawable.ic_arrow_red);
                mSenderName.setText(mContext.getString(R.string.transaction_history_from_me));
                mReceiverName.setText(mContext.getString(R.string.transaction_history_to, transactionEntity.getReceiver().getUserName()));
                mAmount.setText(mContext.getString(R.string.transactions_amount, transactionEntity.getFromAmount(), transactionEntity.getSender().getCurrency()));
                break;
            case TO:
                mDirectionIcon.setImageResource(R.drawable.ic_arrow_gr);
                mSenderName.setText(mContext.getString(R.string.transaction_history_from, transactionEntity.getSender().getUserName()));
                mReceiverName.setText(mContext.getString(R.string.transaction_history_to_me));
                mAmount.setText(mContext.getString(R.string.transactions_amount, transactionEntity.getToAmount(), transactionEntity.getReceiver().getCurrency()));
                break;
        }

        mType.setText(getTypeResource(transactionEntity.getTransactionType()));
        mDate.setText(DateUtils.getFormattedDate("dd.MM.yyyy", transactionEntity.getCreatedAt()));
    }

    @StringRes
    private int getTypeResource(TransactionType transactionType) {
        switch (transactionType) {
            case BORROW:
                return R.string.transaction_history_type_borrow;
            case SEND:
                return R.string.transaction_history_type_send;
            case REQUEST:
                return R.string.transaction_history_type_request;
            case DEPOSIT:
                return R.string.transaction_history_type_deposit;
        }
        return 0;
    }
}