package com.kora.android.data.network.model.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.kora.android.data.network.model.converter.DateTypeCustomConverter;
import com.kora.android.data.network.model.converter.DepositStateConverter;
import com.kora.android.data.network.model.converter.DirectionTypeConverter;
import com.kora.android.presentation.enums.DepositState;
import com.kora.android.presentation.enums.Direction;
import com.kora.android.presentation.enums.RequestState;

import java.util.Date;

@JsonObject
public class DepositResponse {

    @JsonField(name = "id")
    private String mId;
    @JsonField(name = "from")
    private UserResponse mFrom;
    @JsonField(name = "to")
    private UserResponse mTo;
    @JsonField(name = "fromAmount")
    private double mFromAmount;
    @JsonField(name = "toAmount")
    private double mToAmount;
    @JsonField(name = "interestRate")
    private int mInterestRate;
    @JsonField(name = "state", typeConverter = DepositStateConverter.class)
    private DepositState mState;
    @JsonField(name = "createdAt", typeConverter = DateTypeCustomConverter.class)
    private Date mCreatedAt;
    @JsonField(name = "updatedAt", typeConverter = DateTypeCustomConverter.class)
    private Date mUpdatedAt;
    @JsonField(name = "direction", typeConverter = DirectionTypeConverter.class)
    private Direction mDirection;

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public UserResponse getFrom() {
        return mFrom;
    }

    public void setFrom(UserResponse mFrom) {
        this.mFrom = mFrom;
    }

    public UserResponse getTo() {
        return mTo;
    }

    public double getFromAmount() {
        return mFromAmount;
    }

    public double getToAmount() {
        return mToAmount;
    }

    public int getInterestRate() {
        return mInterestRate;
    }

    public void setInterestRate(int mInterestRate) {
        this.mInterestRate = mInterestRate;
    }

    public void setTo(UserResponse mTo) {
        this.mTo = mTo;
    }

    public void setFromAmount(double mFromAmount) {
        this.mFromAmount = mFromAmount;
    }

    public void setToAmount(double mToAmount) {
        this.mToAmount = mToAmount;
    }

    public DepositState getState() {
        return mState;
    }

    public void setState(DepositState mState) {
        this.mState = mState;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public Date getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Date mUpdatedAt) {
        this.mUpdatedAt = mUpdatedAt;
    }

    public Direction getDirection() {
        return mDirection;
    }

    public void setDirection(Direction direction) {
        mDirection = direction;
    }
}
