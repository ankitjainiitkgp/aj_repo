package com.solution.singtel.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ankitkumarjain
 * @version $Id: SingtelClientTemplate.java, v 0.1 2019-09-13 7:49 AM ankitkumarjain Exp $$
 */
public class SingtelClientTemplate {

    static Logger logger = LoggerFactory.getLogger("SOME_LOG");

    public static <T> T execute(SingtelClientCallback<T> callbackAction)
            throws FacadeException {

        long startTime = System.currentTimeMillis();

        T result = null;

        try {
            result = callbackAction.execute();

            if (null == result) {
                String errTips = "outer service return null";
                throw new FacadeException(errTips);
            } else if (!callbackAction.isSuccessResult(result)) {
                throw new FacadeException("outer service call failed - " + result);
            }
        } finally {
            long responseTime = System.currentTimeMillis() - startTime;
            logger.info("callback execution completed. result : " + result.toString() + " rt : " + responseTime);
        }

        return result;
    }
}