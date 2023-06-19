package com.migueljrm95.marvelservice.shared.infrastructure.adapters.out.rest.exception;

public class QueryParamMissing extends RuntimeException{
    public QueryParamMissing(String message){
        super(message);
    }
}
