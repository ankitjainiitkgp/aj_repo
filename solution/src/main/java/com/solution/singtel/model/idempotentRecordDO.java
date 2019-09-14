/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.solution.singtel.model;

import java.util.Date;

/**
 * @author ankitkumarjain
 * @version $Id: idempotentRecordDO.java, v 0.1 2019-09-13 7:15 AM ankitkumarjain Exp $$
 */
public class idempotentRecordDO {

    // unique constraint param
    private String merchantId;

    // unique constraint param
    private String orderId;

    // created time
    private Date createdTime;

    // modified time
    private Date modifiedTime;

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
     * Getter method for property createdTime.
     *
     * @return property value of createdTime
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * Setter method for property createdTime.
     *
     * @param createdTime value to be assigned to property createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Getter method for property modifiedTime.
     *
     * @return property value of modifiedTime
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * Setter method for property modifiedTime.
     *
     * @param modifiedTime value to be assigned to property modifiedTime
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}