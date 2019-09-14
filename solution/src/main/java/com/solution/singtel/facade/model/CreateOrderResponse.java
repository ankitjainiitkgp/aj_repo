package com.solution.singtel.facade.model;

import java.io.Serializable;

/**
 * @author ankitkumarjain
 * @version $Id: CreateOrderResponse.java, v 0.1 2019-09-13 7:32 AM ankitkumarjain Exp $$
 */
public class CreateOrderResponse implements Serializable{

    private static final long serialVersionUID = -7827665301517286707L;

    // id provided by external service
    private String externalServiceOrderId;

    // success result
    private boolean isSuccess;

    // error code
    private String errorCode;

    /**
     * Getter method for property externalServiceOrderId.
     *
     * @return property value of externalServiceOrderId
     */
    public String getExternalServiceOrderId() {
        return externalServiceOrderId;
    }

    /**
     * Setter method for property externalServiceOrderId.
     *
     * @param externalServiceOrderId value to be assigned to property externalServiceOrderId
     */
    public void setExternalServiceOrderId(String externalServiceOrderId) {
        this.externalServiceOrderId = externalServiceOrderId;
    }

    /**
     * Getter method for property isSuccess.
     *
     * @return property value of isSuccess
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * Setter method for property success.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    /**
     * Getter method for property errorCode.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property errorCode.
     *
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}