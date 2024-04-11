package org.example.historyservice.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(Long recordId){
        super("Record not found: " + recordId);
    }
}
