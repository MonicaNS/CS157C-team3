package com.application.inventorymanagement.exception;

import java.text.ParseException;

public class parseException extends ParseException {
    public parseException(String s, int errorOffset) {
        super(s, 5);
    }
}
