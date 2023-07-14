package com.example.AdviceControllerTest.Controller;

import com.example.AdviceControllerTest.Exception.BadRequestException;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    public Message BadRequestException(RuntimeException runtimeException) {
        return new Message(runtimeException.getMessage());
    }
}