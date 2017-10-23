package com.kora.android.presentation.ui.main.fragments.transactions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kora.android.R;
import com.kora.android.common.Keys;
import com.kora.android.di.component.FragmentComponent;
import com.kora.android.presentation.dto.TransactionFilterDto;
import com.kora.android.presentation.model.TransactionEntity;
import com.kora.android.presentation.ui.base.backstack.StackFragment;
import com.kora.android.presentation.ui.base.view.BaseFragment;
import com.kora.android.presentation.ui.main.fragments.transactions.adapter.TransactionAdapter;
import com.kora.android.presentation.ui.main.fragments.transactions.filter.FilterDialog;
import com.kora.android.presentation.ui.send.add_contact.adapter.RecyclerViewScrollListener;
import com.kora.android.views.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TransactionsFragment extends StackFragment<TransactionsPresenter>
        implements TransactionsView, SwipeRefreshLayout.OnRefreshListener,
        FilterDialog.OnClickListener {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.transactions_list) RecyclerView mTransactionsList;
    @BindView(R.id.swipe_layout) SwipeRefreshLayout swipeRefreshLayout;

    private TransactionAdapter mTransactionAdapter;
    private FilterDialog mFilterDialog;

    public static BaseFragment getNewInstance() {
        return new TransactionsFragment();
    }

    @Override
    public void injectToComponent(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_transactions;
    }

    @Override
    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected int getTitle() {
        return R.string.transactions_title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    protected void onViewReady(final Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mTransactionAdapter = new TransactionAdapter(null);
        mTransactionsList.setLayoutManager(layoutManager);
        mTransactionsList.setAdapter(mTransactionAdapter);
        mTransactionsList.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mTransactionsList.getContext(), R.drawable.list_divider);
        mTransactionsList.addItemDecoration(dividerItemDecoration);

        swipeRefreshLayout.setOnRefreshListener(this);

        if (savedInstanceState == null) {
            getPresenter().retrieveTransactionsWithFilter(0);
        } else {
            ArrayList<TransactionEntity> transactions = savedInstanceState.getParcelableArrayList(Keys.Args.TRANSACTION_LIST);
            mTransactionAdapter.addItems(transactions);
            TransactionFilterDto filter = savedInstanceState.getParcelable(Keys.Args.TRANSACTION_FILTER);
            getPresenter().setFilter(filter);
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.transaction_history_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filter:
                getPresenter().onFilterClicked();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRefresh() {
        mTransactionAdapter.clearAll();
        mScrollListener.resetParams();
        getPresenter().retrieveTransactionsWithFilter(0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Keys.Args.TRANSACTION_LIST, (ArrayList<TransactionEntity>) mTransactionAdapter.getItems());
        outState.putParcelable(Keys.Args.TRANSACTION_FILTER, getPresenter().getFilter());
    }

    @Override
    public void enableAndShowRefreshIndicator(boolean enableIndicator, boolean showIndicator) {
        swipeRefreshLayout.setEnabled(enableIndicator);
        swipeRefreshLayout.setRefreshing(showIndicator);
    }

    @Override
    public void showTransactions(List<TransactionEntity> transactionEntities) {
        mTransactionAdapter.addItems(transactionEntities);
    }

    @Override
    public void openFilterDialog() {
        if (mFilterDialog == null) {
            mFilterDialog = FilterDialog.newInstance(new TransactionFilterDto());
            mFilterDialog.setOnClickListener(this);
        }  else if (mFilterDialog.isShowing()) {
            mFilterDialog.dismiss();
        }
        mFilterDialog.show(getActivity().getSupportFragmentManager());

    }

    @Override
    public void onCancelFilter() {

    }

    @Override
    public void onFilterChanged(TransactionFilterDto transactionFilterDto) {
        mTransactionAdapter.clearAll();
        getPresenter().retrieveTransactions(transactionFilterDto, 0);
    }

    private final RecyclerViewScrollListener mScrollListener = new RecyclerViewScrollListener() {

        @Override
        public void onScrolled(final RecyclerView recyclerView, final int dx, final int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onLoadMore(final int totalItemsCount) {
            getPresenter().retrieveTransactionsWithFilter(mTransactionAdapter.getItemCount());
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        mTransactionsList.addOnScrollListener(mScrollListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        mTransactionsList.removeOnScrollListener(mScrollListener);
    }
}
