package com.kora.android.domain.usecase.transaction;

import com.kora.android.data.repository.TransactionRepository;
import com.kora.android.di.annotation.ConfigPersistent;
import com.kora.android.domain.base.AsyncUseCase;
import com.kora.android.presentation.enums.TransactionType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

@ConfigPersistent
public class AddToTransactionsUseCase extends AsyncUseCase {

    private final TransactionRepository mTransactionRepository;

    private TransactionType mType;
    private String mTo;
    private double mFromAmount;
    private double mToAmount;
    private List<String> mTransactionHash;

    public void setData(final TransactionType type,
                        final String to,
                        final double fromAmount,
                        final double toAmount,
                        final List<String> transactionHash) {
        mType = type;
        mTo = to;
        mFromAmount = fromAmount;
        mToAmount = toAmount;
        mTransactionHash = transactionHash;
    }

    @Inject
    public AddToTransactionsUseCase(final TransactionRepository transactionRepository) {
        mTransactionRepository = transactionRepository;
    }

    @Override
    protected Observable buildObservableTask() {
        return mTransactionRepository.addToTransactions(
                mType.name().toLowerCase(),
                mTo,
                mFromAmount,
                mToAmount,
                mTransactionHash
        );
    }
}
