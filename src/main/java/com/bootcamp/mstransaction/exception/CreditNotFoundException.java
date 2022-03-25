package com.bootcamp.mstransaction.exception;

public class CreditNotFoundException extends  RuntimeException{

    private static final String MESSAGE = "CREDIT CLIENT NOT FOUND";

    public CreditNotFoundException(){
        super(MESSAGE);
    }
}
