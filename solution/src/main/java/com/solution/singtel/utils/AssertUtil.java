package com.solution.singtel.utils;

import org.apache.maven.shared.utils.StringUtils;

/**
 * @author ankitkumarjain
 * @version $Id: AssertUtil.java, v 0.1 2019-09-12 7:35 PM ankitkumarjain Exp $$
 */
public class AssertUtil {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notBlank(String object, String message) {
        if (StringUtils.isBlank(object)) {
            throw new IllegalArgumentException(message);
        }
    }
}