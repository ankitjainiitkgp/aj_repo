package com.solution.singtel.ratelimiter.impl;

import com.solution.singtel.common.Constants;
import com.solution.singtel.ratelimiter.IRateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author ankitkumarjain
 * @version $Id: RateLimitServiceImpl.java, v 0.1 2019-09-13 10:05 AM ankitkumarjain Exp $$
 */
@Service("ratelimitService")
public class RateLimitServiceImpl implements IRateLimitService {

    @Autowired
    private Environment env;

    /**
     * using redis for rate limiting throttling
     *
     * As we have single API, for which ratelimiting need to be placed
     * We will keep key in redis as follows
     *  API_yyyyMMddHHmmss :: singtelOrderCreate_20190913105302
     * Value of this would be the maximum allowed TPS for the API, which can be fetched from the property file
     * Let's call it as token. if token's value is 0, then we should NOT go ahead with new request.
     *
     * Whenever a new request comes, value of current key is being checked - singtelOrderCreate_20190913105302
     * if we get a valid token, GETSET api of redis should be called with new value = currentValue - 1
     *
     * if the response of GETSET (older value) is not same as the one we get earlier, we should retry with
     * latest value - 1 until we successfully able to update
     *
     * TO FURTHER improvement in performance -
     * i will use JVMCache, which would be very faster - So now, JVMCache will take pool of token from
     * global redis server and if tokens available, it will allow that server to go ahead with external API call.
     *
     * @return
     */
    @Override
    public boolean getAvailabilityAndUpdate(){

        // check availability in current time window for rate limiting
        Long rateLimit  = Long.getLong(env.getProperty(Constants.KEY_API_ORDER_CREATE_RATE_LIMIT_PER_SEC));

        // check redis - get the counter from global redis
        // getvalue as per currentsecond key = orderCreate_yyyyMMddHHmmss
        // if value did not find,
        // then add new key with current second and value = rateLimit - 1
        // return true
        // else if value <= 0
        // return false
        // else
        // GETSET redis value = current value - 1
        // if old value is not same as value we get earlier, by which decision is taken then retry with GETSET currentValue -1
        // if set successful - return true
        return true;
    }
}