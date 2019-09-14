/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.solution.singtel.consumer;

import com.solution.singtel.facade.OrderService;
import com.solution.singtel.facade.model.CreateOrderRequest;
import com.solution.singtel.ratelimiter.IRateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author ankitkumarjain
 * @version $Id: OrderRequestConsumer.java, v 0.1 2019-09-12 11:45 PM ankitkumarjain Exp $$
 */
public class OrderRequestConsumer implements Runnable {

    @Autowired
    private Environment env;

    @Autowired
    OrderService singtelOrderService;

    @Autowired
    IRateLimitService ratelimitService;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try {
            CreateOrderRequest request = readMessage();

            // check idempotancy
            boolean isidempotantReq = validateIdempotancy(request);

            if(!isidempotantReq) {
                ratelimitService.getAvailabilityAndUpdate();

                // call the external API
                singtelOrderService.createOrder(request);
            }

        } catch(Exception e){
            // 1. do not send ack to msgBroker and allow retry to consume the same message
            // 2. increase availability token number
            // 3/ rollback the DB commit
        }
    }

    private CreateOrderRequest readMessage(){
        // read message from the msgBroker queue
        // parse it to create CreateOrderRequest object from payload

        return null;
    }

    /**
     * I will maintain a DB table, which will containing following columns
     *  orderId
     *  merchantId
     *  createdTime
     *
     *  uniqueConstraint on orderId + merchantId
     *  index on both orderId and merchantId
     *
     * @param req
     * @return
     */
    private boolean validateIdempotancy(CreateOrderRequest req){
        // insert in DB, mid+orderId

        // if uniqueConstraint is returned, >> it is idempotant request
            // return true
        // else return false;

        return  false;
    }
}