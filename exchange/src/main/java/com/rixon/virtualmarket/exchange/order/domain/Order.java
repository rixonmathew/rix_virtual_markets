package com.rixon.virtualmarket.exchange.order.domain;

import java.util.Date;

/**
 * This entity represents the Trade Order domain object. This entity is modelled aroung the NewSingleOrder message as specified
 * by FIX 4.4
 *
 * User: rixon
 * Date: 13/8/13
 * Time: 5:32 PM
 */
public class Order {

    private String orderID;
    private String secondaryOrderID;
    private Date tradeOriginationDate;
    private Date tradeDate;
    private String account;
    private String accountIDSource;
    private String accountType;
    private String dayBookingInstitue;
    private String bookingUnit;
    private String preallocationMethod;
    private String allocationId;
    private String preallocationGroup;
    private String settlementType;
    private Date settlementDate;
    private String cashMargin;
    private String clearingFeeIndicator;
    private String handlingInstitute;
    private String executingInstitute;
    private String minimumQuantity;


    public Order() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSecondaryOrderID() {
        return secondaryOrderID;
    }

    public void setSecondaryOrderID(String secondaryOrderID) {
        this.secondaryOrderID = secondaryOrderID;
    }

    public Date getTradeOriginationDate() {
        return tradeOriginationDate;
    }

    public void setTradeOriginationDate(Date tradeOriginationDate) {
        this.tradeOriginationDate = tradeOriginationDate;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountIDSource() {
        return accountIDSource;
    }

    public void setAccountIDSource(String accountIDSource) {
        this.accountIDSource = accountIDSource;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDayBookingInstitue() {
        return dayBookingInstitue;
    }

    public void setDayBookingInstitue(String dayBookingInstitue) {
        this.dayBookingInstitue = dayBookingInstitue;
    }

    public String getBookingUnit() {
        return bookingUnit;
    }

    public void setBookingUnit(String bookingUnit) {
        this.bookingUnit = bookingUnit;
    }

    public String getPreallocationMethod() {
        return preallocationMethod;
    }

    public void setPreallocationMethod(String preallocationMethod) {
        this.preallocationMethod = preallocationMethod;
    }

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public String getPreallocationGroup() {
        return preallocationGroup;
    }

    public void setPreallocationGroup(String preallocationGroup) {
        this.preallocationGroup = preallocationGroup;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getCashMargin() {
        return cashMargin;
    }

    public void setCashMargin(String cashMargin) {
        this.cashMargin = cashMargin;
    }

    public String getClearingFeeIndicator() {
        return clearingFeeIndicator;
    }

    public void setClearingFeeIndicator(String clearingFeeIndicator) {
        this.clearingFeeIndicator = clearingFeeIndicator;
    }

    public String getHandlingInstitute() {
        return handlingInstitute;
    }

    public void setHandlingInstitute(String handlingInstitute) {
        this.handlingInstitute = handlingInstitute;
    }

    public String getExecutingInstitute() {
        return executingInstitute;
    }

    public void setExecutingInstitute(String executingInstitute) {
        this.executingInstitute = executingInstitute;
    }

    public String getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(String minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }
}
