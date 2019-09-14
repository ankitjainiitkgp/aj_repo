package com.solution.singtel.facade.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ankitkumarjain
 * @version $Id: CreateOrderRequest.java, v 0.1 2019-09-13 7:33 AM ankitkumarjain Exp $$
 */
public class CreateOrderRequest implements Serializable{

    private static final long serialVersionUID = 7531243331565975124L;

    // orderId provided by merchant
    @NotBlank(message = "order id should not be blank")
    private String orderId;

    // merchantId
    @NotBlank(message = "merchant id should not be blank")
    private String merchantId;

    // date time of order creation in the ISO format
    @NotBlank(message = "created time should not be blank")
    private String createdTime;

    // amount for the order in cents
    @Min(value = 0L, message = "amount should be positive")
    private Long amount;

    // currency of the payable amount
    @NotBlank(message = "currency should not be blank")
    private String currency;

    // customer id provided by merchant
    private String customerId;

    // extended info in the form of json of Map<String,String>
    private String extendedInfo;

    /**
     * Getter method for property orderId.
     *
     * @return property value of orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Setter method for property orderId.
     *
     * @param orderId value to be assigned to property orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter method for property merchantId.
     *
     * @return property value of merchantId
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Setter method for property merchantId.
     *
     * @param merchantId value to be assigned to property merchantId
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Getter method for property createdTime.
     *
     * @return property value of createdTime
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * Setter method for property createdTime.
     *
     * @param createdTime value to be assigned to property createdTime
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Getter method for property amount.
     *
     * @return property value of amount
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Setter method for property amount.
     *
     * @param amount value to be assigned to property amount
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * Getter method for property currency.
     *
     * @return property value of currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter method for property currency.
     *
     * @param currency value to be assigned to property currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Getter method for property customerId.
     *
     * @return property value of customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Setter method for property customerId.
     *
     * @param customerId value to be assigned to property customerId
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter method for property extendedInfo.
     *
     * @return property value of extendedInfo
     */
    public String getExtendedInfo() {
        return extendedInfo;
    }

    /**
     * Setter method for property extendedInfo.
     *
     * @param extendedInfo value to be assigned to property extendedInfo
     */
    public void setExtendedInfo(String extendedInfo) {
        this.extendedInfo = extendedInfo;
    }
}