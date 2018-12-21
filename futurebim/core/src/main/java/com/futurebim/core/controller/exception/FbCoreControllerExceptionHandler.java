package com.futurebim.core.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.futurebim.common.model.reponse.FBRestResponse;

@ControllerAdvice
public class FbCoreControllerExceptionHandler {
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  protected ResponseEntity<FBRestResponse> handleConflict(final RuntimeException ex, final WebRequest request) {
    // return new FBRestResponse(HttpStatus.CONFLICT, ex);
    final HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", MediaType.APPLICATION_XML_VALUE + ";charset=UTF-8");
    return new ResponseEntity<>(new FBRestResponse(HttpStatus.CONFLICT, ex), headers, HttpStatus.CONFLICT);
  }
}
