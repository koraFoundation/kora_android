package com.kora.android.data.network.model.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class UserResponse {

    @JsonField(name = "id")
    private String mId;
    @JsonField(name = "avatar")
    private String mAvatar;
    @JsonField(name = "phone")
    private String mPhoneNumber;
    @JsonField(name = "identity")
    private String mIdentity;
    @JsonField(name = "creator")
    private String mCreator;
    @JsonField(name = "recoveryKey")
    private String mRecoveryKey;
    @JsonField(name = "owner")
    private String mOwner;
    @JsonField(name = "userName")
    private String mUserName;
    @JsonField(name = "legalName")
    private String mLegalName;
    @JsonField(name = "email")
    private String mEmail;
    @JsonField(name = "dateOfBirth")
    private String mDateOfBirth;
    @JsonField(name = "currency")
    private String mCurrency;
    @JsonField(name = "postalCode")
    private String mPostalCode;
    @JsonField(name = "countryCode")
    private String mCountryCode;
    @JsonField(name = "address")
    private String mAddress;
    @JsonField(name = "ERC20Token")
    private String mERC20Token;
    @JsonField(name = "flag")
    private String mFlag;
    @JsonField(name = "currencyNameFull")
    private String mCurrencyNameFull;
    @JsonField(name = "agree")
    private Boolean mAgreed;
    @JsonField(name = "agent")
    private Boolean mAgent;
    @JsonField(name = "interestRate")
    private Integer mInterestRate;
    @JsonField(name = "emailVerified")
    private Boolean mEmailVerified;
    @JsonField(name = "isKoraMoneySent")
    private Boolean mIsKoraMoneySent;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getIdentity() {
        return mIdentity;
    }

    public void setIdentity(String identity) {
        mIdentity = identity;
    }

    public String getCreator() {
        return mCreator;
    }

    public void setCreator(String creator) {
        mCreator = creator;
    }

    public String getRecoveryKey() {
        return mRecoveryKey;
    }

    public void setRecoveryKey(String recoveryKey) {
        mRecoveryKey = recoveryKey;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getLegalName() {
        return mLegalName;
    }

    public void setLegalName(String legalName) {
        mLegalName = legalName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getERC20Token() {
        return mERC20Token;
    }

    public void setERC20Token(String ERC20Token) {
        mERC20Token = ERC20Token;
    }

    public String getFlag() {
        return mFlag;
    }

    public void setFlag(String flag) {
        mFlag = flag;
    }

    public String getCurrencyNameFull() {
        return mCurrencyNameFull;
    }

    public void setCurrencyNameFull(String currencyNameFull) {
        mCurrencyNameFull = currencyNameFull;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
    }

    public Boolean getAgreed() {
        return mAgreed;
    }

    public void setAgreed(Boolean agreed) {
        mAgreed = agreed;
    }

    public Boolean getAgent() {
        return mAgent;
    }

    public void setAgent(Boolean mAgent) {
        this.mAgent = mAgent;
    }

    public Integer getInterestRate() {
        return mInterestRate;
    }

    public void setInterestRate(Integer mInterestRate) {
        this.mInterestRate = mInterestRate;
    }

    public Boolean getEmailVerified() {
        return mEmailVerified;
    }

    public void setEmailVerified(Boolean mEmailVerified) {
        this.mEmailVerified = mEmailVerified;
    }

    public Boolean getIsKoraMoneySent() {
        return mIsKoraMoneySent;
    }

    public void setIsKoraMoneySent(Boolean mIsKoraMoneySent) {
        this.mIsKoraMoneySent = mIsKoraMoneySent;
    }
}
