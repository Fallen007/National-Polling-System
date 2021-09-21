package com.national.polling.system.exception;

public class ConflictWithExistingRecordException extends RuntimeException{
    public ConflictWithExistingRecordException(String message){
        super(message);
    }
}
