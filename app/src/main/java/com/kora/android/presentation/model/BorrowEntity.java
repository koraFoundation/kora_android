package com.kora.android.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.kora.android.presentation.enums.BorrowState;
import com.kora.android.presentation.enums.BorrowType;
import com.kora.android.presentation.enums.Direction;

import java.util.Date;
import java.util.List;

public class BorrowEntity implements Parcelable {

    private String id;
    private Direction direction;
    private BorrowState state;
    private double fromAmount;
    private double toAmount;
    private int rate;
    private String additionalNote;
    private Date startDate;
    private Date maturityDate;
    private Date createdAt;
    private UserEntity sender;
    private UserEntity receiver;
    private List<UserEntity> guarantors;
    private String loanId;
    private BorrowType type;
    private double fromTotalAmount;
    private double toFromAmount;
    private double fromBalance;
    private double toBalance;
    private double fromReturnedMoney;
    private double toReturnedMoney;

    public BorrowEntity(String id,
                        Direction direction,
                        BorrowState state,
                        double fromAmount,
                        double toAmount,
                        int rate,
                        String additionalNote,
                        Date startDate,
                        Date maturityDate,
                        Date createdAt,
                        UserEntity sender,
                        UserEntity receiver,
                        List<UserEntity> guarantors,
                        String loanId,
                        BorrowType type,
                        double fromTotalAmount,
                        double toFromAmount,
                        double fromBalance,
                        double toBalance,
                        double fromReturnedMoney,
                        double toReturnedMoney) {
        this.id = id;
        this.direction = direction;
        this.state = state;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.rate = rate;
        this.additionalNote = additionalNote;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.createdAt = createdAt;
        this.sender = sender;
        this.receiver = receiver;
        this.guarantors = guarantors;
        this.loanId = loanId;
        this.type = type;
        this.fromTotalAmount = fromTotalAmount;
        this.toFromAmount = toFromAmount;
        this.fromBalance = fromBalance;
        this.toBalance = toBalance;
        this.fromReturnedMoney = fromReturnedMoney;
        this.toReturnedMoney = toReturnedMoney;
    }

    protected BorrowEntity(Parcel in) {
        id = in.readString();
        fromAmount = in.readDouble();
        toAmount = in.readDouble();
        rate = in.readInt();
        state = BorrowState.valueOf(in.readString());
        direction = Direction.valueOf(in.readString());
        additionalNote = in.readString();
        sender = in.readParcelable(UserEntity.class.getClassLoader());
        receiver = in.readParcelable(UserEntity.class.getClassLoader());
        guarantors = in.createTypedArrayList(UserEntity.CREATOR);
        long startDateLong = in.readLong();
        startDate = startDateLong == -1 ? null : new Date(startDateLong);
        long maturityDateLong = in.readLong();
        maturityDate = maturityDateLong == -1 ? null : new Date(maturityDateLong);
        long createdAtLong = in.readLong();
        createdAt = createdAtLong == -1 ? null : new Date(createdAtLong);
        loanId = in.readString();
        type = BorrowType.valueOf(in.readString());
        fromTotalAmount = in.readDouble();
        toFromAmount = in.readDouble();
        fromBalance = in.readDouble();
        toBalance = in.readDouble();
        fromReturnedMoney = in.readDouble();
        toReturnedMoney = in.readDouble();
    }

    public static final Creator<BorrowEntity> CREATOR = new Creator<BorrowEntity>() {
        @Override
        public BorrowEntity createFromParcel(Parcel in) {
            return new BorrowEntity(in);
        }

        @Override
        public BorrowEntity[] newArray(int size) {
            return new BorrowEntity[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public BorrowState getState() {
        return state;
    }

    public void setState(BorrowState state) {
        this.state = state;
    }

    public double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getToAmount() {
        return toAmount;
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAdditionalNote() {
        return additionalNote;
    }

    public void setAdditionalNote(String additionalNote) {
        this.additionalNote = additionalNote;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public UserEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }

    public List<UserEntity> getGuarantors() {
        return guarantors;
    }

    public void setGuarantors(List<UserEntity> guarantors) {
        this.guarantors = guarantors;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public BorrowType getType() {
        return type;
    }

    public void setType(BorrowType type) {
        this.type = type;
    }

    public double getFromTotalAmount() {
        return fromTotalAmount;
    }

    public void setFromTotalAmount(double fromTotalAmount) {
        this.fromTotalAmount = fromTotalAmount;
    }

    public double getToFromAmount() {
        return toFromAmount;
    }

    public void setToFromAmount(double toFromAmount) {
        this.toFromAmount = toFromAmount;
    }

    public double getFromBalance() {
        return fromBalance;
    }

    public void setFromBalance(double fromBalance) {
        this.fromBalance = fromBalance;
    }

    public double getToBalance() {
        return toBalance;
    }

    public void setToBalance(double toBalance) {
        this.toBalance = toBalance;
    }

    public double getFromReturnedMoney() {
        return fromReturnedMoney;
    }

    public void setFromReturnedMoney(double fromReturnedMoney) {
        this.fromReturnedMoney = fromReturnedMoney;
    }

    public double getToReturnedMoney() {
        return toReturnedMoney;
    }

    public void setToReturnedMoney(double toReturnedMoney) {
        this.toReturnedMoney = toReturnedMoney;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeDouble(fromAmount);
        dest.writeDouble(toAmount);
        dest.writeInt(rate);
        dest.writeString(state.name());
        dest.writeString(direction.name());
        dest.writeString(additionalNote);
        dest.writeParcelable(sender, flags);
        dest.writeParcelable(receiver, flags);
        dest.writeTypedList(guarantors);
        dest.writeLong(startDate == null ? -1 : startDate.getTime());
        dest.writeLong(maturityDate == null ? -1 : maturityDate.getTime());
        dest.writeLong(createdAt == null ? -1 : createdAt.getTime());
        dest.writeString(loanId);
        dest.writeString(type.name());
        dest.writeDouble(fromTotalAmount);
        dest.writeDouble(toFromAmount);
        dest.writeDouble(fromBalance);
        dest.writeDouble(toBalance);
        dest.writeDouble(fromReturnedMoney);
        dest.writeDouble(toReturnedMoney);
    }
}
