package com.difelix.personaldataregistration.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<Map<String, List<ErrorMessageResponse>>> methodArgumentNotValidationException(
      MethodArgumentNotValidException ex) {
    List<ErrorMessageResponse> errors = ex
        .getBindingResult()
        .getFieldErrors()
        .stream()
        .map(fieldError ->
          ErrorMessageResponse.builder()
              .message(fieldError.getDefaultMessage())
              .field(fieldError.getField())
              .build()
        )
        .toList();

    Map<String, List<ErrorMessageResponse>> response = new HashMap<>();
    response.put("errors", errors);

    return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
}
