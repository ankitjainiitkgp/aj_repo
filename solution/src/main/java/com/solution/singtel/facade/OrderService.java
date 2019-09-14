/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.solution.singtel.facade;

import com.solution.singtel.facade.model.CreateOrderRequest;
import com.solution.singtel.facade.model.CreateOrderResponse;

/**
 * @author ankitkumarjain
 * @version $Id: OrderService.java, v 0.1 2019-09-13 7:23 AM ankitkumarjain Exp $$
 */
public interface OrderService {

    /**
     * This interface is to call external service to createOrder
     *
     * @param request
     * @return
     * @throws FacadeException
     */
    public CreateOrderResponse createOrder(CreateOrderRequest request) throws FacadeException;
}