package com.kora.android.domain.usecase.borrow;

import com.kora.android.data.repository.BorrowRepository;
import com.kora.android.di.annotation.ConfigPersistent;
import com.kora.android.domain.base.AsyncUseCase;
import com.kora.android.presentation.enums.BorrowListType;

import javax.inject.Inject;

import io.reactivex.Observable;

@ConfigPersistent
public class GetBorrowUseCase extends AsyncUseCase {

    private final BorrowRepository mBorrowRepository;

    private int mSkip = 0;
    private BorrowListType mBorrowListType;

    @Inject
    public GetBorrowUseCase(BorrowRepository borrowRepository) {
        mBorrowRepository = borrowRepository;
    }

    public void setData(int skip, BorrowListType borrowListType) {
        mSkip = skip;
        mBorrowListType = borrowListType;
    }

    @Override
    protected Observable buildObservableTask() {
        return mBorrowRepository.loadBorrowList(mSkip, mBorrowListType);
    }
}
