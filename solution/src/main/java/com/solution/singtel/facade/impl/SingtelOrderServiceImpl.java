package com.solution.singtel.facade.impl;

import com.solution.singtel.facade.FacadeException;
import com.solution.singtel.facade.OrderService;
import com.solution.singtel.facade.SingtelClientCallback;
import com.solution.singtel.facade.SingtelClientTemplate;
import com.solution.singtel.facade.model.CreateOrderRequest;
import com.solution.singtel.facade.model.CreateOrderResponse;
import org.springframework.stereotype.Service;

/**
 * @author ankitkumarjain
 * @version $Id: SingtelOrderServiceImpl.java, v 0.1 2019-09-13 7:35 AM ankitkumarjain Exp $$
 */
@Service("singtelOrderService")
public class SingtelOrderServiceImpl implements OrderService {

    /**
     * This interface is to call external service to createOrder
     *
     * @param request
     * @return
     * @throws com.solution.singtel.facade.FacadeException
     */
    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) throws FacadeException {

        return SingtelClientTemplate.execute(new SingtelClientCallback<CreateOrderResponse>() {
            @Override
            public CreateOrderResponse execute() {
                // call external service
                return new CreateOrderResponse();
            }

            @Override
            public boolean isSuccessResult(CreateOrderResponse result) {
                return true;
            }
        });
    }
}