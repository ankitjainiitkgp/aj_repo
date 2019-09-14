package com.solution.singtel.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ankitkumarjain
 * @version $Id: OrderRequestDTO.java, v 0.1 2019-09-13 7:20 AM ankitkumarjain Exp $$
 */
public class OrderRequestDTO implements Serializable{


    private static final long serialVersionUID = -2134492667888817295L;

    // message payload
    private Object payload;

    // event code for the queue
    private String eventCode;

    // unique message id
    private String messageId;

    // timestamp
    private Date timeStamp;

    /**
     * Getter method for property serialVersionUID.
     *
     * @return property value of serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Getter method for property payload.
     *
     * @return property value of payload
     */
    public Object getPayload() {
        return payload;
    }

    /**
     * Setter method for property payload.
     *
     * @param payload value to be assigned to property payload
     */
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    /**
     * Getter method for property eventCode.
     *
     * @return property value of eventCode
     */
    public String getEventCode() {
        return eventCode;
    }

    /**
     * Setter method for property eventCode.
     *
     * @param eventCode value to be assigned to property eventCode
     */
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    /**
     * Getter method for property messageId.
     *
     * @return property value of messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Setter method for property messageId.
     *
     * @param messageId value to be assigned to property messageId
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Getter method for property timeStamp.
     *
     * @return property value of timeStamp
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * Setter method for property timeStamp.
     *
     * @param timeStamp value to be assigned to property timeStamp
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}