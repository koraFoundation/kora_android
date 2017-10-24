package com.kora.android.data.repository.mapper;

import com.kora.android.data.network.model.response.RequestResponse;
import com.kora.android.presentation.model.RequestEntity;
import com.kora.android.presentation.model.builder.RequestEntityBuilder;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class RequestMapper {

    private final UserMapper mUserMapper;

    @Inject
    public RequestMapper(final UserMapper userMapper) {
        mUserMapper = userMapper;
    }

    public ObservableTransformer<RequestResponse, RequestEntity> transformResponseToRequestEntity() {
        return requestResponseObservable -> requestResponseObservable
                .filter(requestResponse -> requestResponse.getFrom() != null && requestResponse.getTo() != null)
                .flatMap(requestResponse ->
                        Observable.zip(
                                mUserMapper.transformResponseToEntityUser(requestResponse.getFrom()),
                                mUserMapper.transformResponseToEntityUser(requestResponse.getTo()),
                                (from, to) -> new RequestEntityBuilder()
                                        .setFrom(from)
                                        .setTo(to)
                                        .setFromAmount(requestResponse.getFromAmount())
                                        .setToAmount(requestResponse.getToAmount())
                                        .setAdditionalNote(requestResponse.getAdditionalNote())
                                        .setState(requestResponse.getState())
                                        .setCreatedAt(requestResponse.getCreatedAt())
                                        .createRequestEntity()));
    }

}
