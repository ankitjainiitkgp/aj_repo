package com.solution.singtel.ratelimiter;

/**
 * @author ankitkumarjain
 * @version $Id: IRateLimitService.java, v 0.1 2019-09-13 10:06 AM ankitkumarjain Exp $$
 */
public interface IRateLimitService {

    public boolean getAvailabilityAndUpdate();
}