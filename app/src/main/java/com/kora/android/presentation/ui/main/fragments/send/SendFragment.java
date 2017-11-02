package com.kora.android.presentation.ui.main.fragments.send;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.kora.android.R;
import com.kora.android.common.Keys;
import com.kora.android.di.component.FragmentComponent;
import com.kora.android.presentation.enums.ActionType;
import com.kora.android.presentation.model.UserEntity;
import com.kora.android.presentation.ui.adapter.UserAdapter;
import com.kora.android.presentation.ui.base.adapter.OnItemClickListener;
import com.kora.android.presentation.ui.base.backstack.StackFragment;
import com.kora.android.presentation.ui.base.view.BaseFragment;
import com.kora.android.presentation.ui.common.add_contact.GetContactActivity;
import com.kora.android.presentation.ui.common.send_to.RequestDetailsActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

public class SendFragment extends StackFragment<SendPresenter> implements SendView,
        OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    private static final int REQUEST_CREATE = 555;
    private static final int REQUEST_GET_CONTACT = 556;
    @BindView(R.id.toolbar) Toolbar mToolbar;

    @BindView(R.id.user_list) RecyclerView mUserList;
    @BindView(R.id.swipe_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.text_add_new_contact) TextView mAddContactButton;

    private UserAdapter mUserAdapter;

    public static BaseFragment getNewInstance() {
        return new SendFragment();
    }

    @Override
    public void injectToComponent(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.fragment_send;
    }

    @Override
    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected int getTitle() {
        return R.string.send_money_title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserAdapter = new UserAdapter();
        mUserAdapter.setOnUserClickListener(this);
    }

    @Override
    protected void onViewReady(final Bundle savedInstanceState) {
        mUserList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mUserList.setAdapter(mUserAdapter);
        mUserList.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.setOnRefreshListener(this);

        if (savedInstanceState == null) {
            getPresenter().getUserList();
        } else {
            ArrayList<UserEntity> users = savedInstanceState.getParcelableArrayList(Keys.Args.USER_LIST);
            mUserAdapter.addUsers(users);
        }

    }

    @Override
    public void showUserList(List<UserEntity> users) {
        Collections.sort(users, (o1, o2) -> o1.getFullName().compareTo(o2.getFullName()));
        mUserAdapter.addUsers(users);
        mUserList.invalidate();
    }

    @Override
    public void onItemClicked(int position) {
        startActivityForResult(RequestDetailsActivity.getLaunchIntent(getBaseActivity(),
                mUserAdapter.getItem(position), ActionType.SEND_MONEY), REQUEST_CREATE);
    }

    @OnClick(R.id.text_add_new_contact)
    public void onAddContactClicked() {
        startActivityForResult(GetContactActivity.getLaunchIntent(getBaseActivity(), getString(R.string.send_money_title)), REQUEST_GET_CONTACT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CREATE:

                    break;

                case REQUEST_GET_CONTACT:
                    UserEntity user = data.getParcelableExtra(Keys.Extras.EXTRA_USER);
                    startActivityForResult(RequestDetailsActivity.getLaunchIntent(getBaseActivity(),
                            user, ActionType.SEND_MONEY), REQUEST_CREATE);
                    break;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Keys.Args.USER_LIST, (ArrayList<UserEntity>) mUserAdapter.getItems());
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
        mUserAdapter.clearAll();
        getPresenter().getUserList();
    }
}
