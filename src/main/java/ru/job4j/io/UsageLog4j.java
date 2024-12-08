package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean flag = true;
        char c = 'c';
        byte byteVar = 120;
        short shortVar = 32000;
        int intVar = 2_000_000_000;
        long longVar = 8_000_000_000_000L;
        float floatVar = 3.1E-30F;
        double doubleVar = 1.2E300;
        LOG.debug("boolean variable : {}, char variable : {}", flag, c);
        LOG.debug("byte variable : {}, short variable : {}", byteVar, shortVar);
        LOG.debug("int variable : {}, long variable : {}", intVar, longVar);
        LOG.debug("float variable : {}, double variable : {}", floatVar, doubleVar);
    }
}