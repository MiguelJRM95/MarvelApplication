package com.migueljrm95.marvelservice.shared.infrastructure.adapters.out.rest.exception;

import com.migueljrm95.marvelservice.shared.infrastructure.adapters.out.rest.exception.response.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomizedExceptionAdapter extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                LocalDateTime.now(),
                ex.getMessage(),
                null,
                List.of(request.getDescription(false))
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Integer.toString(HttpStatus.NOT_FOUND.value()),
                LocalDateTime.now(),
                ex.getMessage(),
                null,
                List.of(request.getDescription(false))
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(QueryParamMissing.class)
    public final ResponseEntity<Object> handleQueryParamMissingException(RuntimeException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Integer.toString(HttpStatus.BAD_REQUEST.value()),
                LocalDateTime.now(),
                ex.getMessage(),
                null,
                List.of(request.getDescription(false))
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Integer.toString(status.value()),
                LocalDateTime.now(),
                null,
                getErrorsMap(errors),
                List.of(request.getDescription(false))
        );
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
