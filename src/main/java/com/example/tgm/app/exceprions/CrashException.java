package com.example.tgm.app.exceprions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class CrashException extends RuntimeException{
    public CrashException(){
        super();
    }

    public CrashException(String message){
        super(message);
    }
}
