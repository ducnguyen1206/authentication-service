package com.ddd.sample.utils;

import org.apache.logging.log4j.util.Strings;

public class SecurityUtils {

    private SecurityUtils() {
    }

    public static String getUser(String jwt) {
        if (Strings.isEmpty(jwt)) {
            // TODO exception
            return "System";
        }
        return "System";
    }
}
