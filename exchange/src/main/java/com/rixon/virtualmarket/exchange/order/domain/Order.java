package com.rixon.virtualmarket.exchange.order.domain;

import java.util.Date;

/**
 * This entity represents the Trade Order domain object. This entity is modelled around the
 * NewSingleOrder message as specified in FIX 4.4
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
    private String dayBookingInstitute;
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
    private String instrument;
    private Side side;
    private Date transactTime;
    private String orderQuantity; //TODO This should be a complex type as per FIX specification
    private OrderType orderType;

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

    public String getDayBookingInstitute() {
        return dayBookingInstitute;
    }

    public void setDayBookingInstitute(String dayBookingInstitute) {
        this.dayBookingInstitute = dayBookingInstitute;
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

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Date getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(Date transactTime) {
        this.transactTime = transactTime;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderID != null ? !orderID.equals(order.orderID) : order.orderID != null) return false;
        if (tradeDate != null ? !tradeDate.equals(order.tradeDate) : order.tradeDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderID != null ? orderID.hashCode() : 0;
        result = 31 * result + (tradeDate != null ? tradeDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", tradeDate=" + tradeDate +
                '}';
    }
}