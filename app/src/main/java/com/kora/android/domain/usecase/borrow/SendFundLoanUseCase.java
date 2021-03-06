package com.kora.android.domain.usecase.borrow;

import com.kora.android.data.repository.BorrowRepository;
import com.kora.android.di.annotation.ConfigPersistent;
import com.kora.android.domain.base.AsyncUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

@ConfigPersistent
public class SendFundLoanUseCase extends AsyncUseCase {

    private final BorrowRepository mBorrowRepository;

    private String mBorrowId;
    private String mRawApprove;
    private String mRawFundLoan;

    @Inject
    public SendFundLoanUseCase(final BorrowRepository borrowRepository) {
        mBorrowRepository = borrowRepository;
    }

    public void setData(final String borrowId,
                        final String rawApprove,
                        final String rawFundLoan) {
        mBorrowId = borrowId;
        mRawApprove = rawApprove;
        mRawFundLoan = rawFundLoan;
    }


    @Override
    protected Observable buildObservableTask() {
        return mBorrowRepository.sendFundLoan(mBorrowId, mRawApprove, mRawFundLoan);
    }
}
