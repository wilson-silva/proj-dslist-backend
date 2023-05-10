package com.devsuperior.dslist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice
public class GameControllerAdvice {

    @ResponseBody
    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> gameNotFound(GameNotFoundException gameNotFoundException) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Game not found!"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(GameListNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> gameListNotFound(GameListNotFoundException gameListNotFoundException) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.NOT_FOUND.value(), "Game list not found!"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
