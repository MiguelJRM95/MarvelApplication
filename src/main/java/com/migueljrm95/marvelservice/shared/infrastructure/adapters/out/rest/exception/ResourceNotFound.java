package com.migueljrm95.marvelservice.shared.infrastructure.adapters.out.rest.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message){
        super(message);
    }
}
