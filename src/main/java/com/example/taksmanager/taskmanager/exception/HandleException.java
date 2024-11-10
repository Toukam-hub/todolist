package com.example.taksmanager.taskmanager.exception;

import com.example.taksmanager.taskmanager.exception.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(ResourceAlresdyExistException.class)
    public ResponseEntity<Message> handleAlreadyExistException(ResourceAlresdyExistException e){
        Message message = new Message();
        message.setCode(HttpStatus.CONFLICT.value());
        message.setMessage(e.getMessage());
        message.setDate(LocalDate.now());
        return new ResponseEntity<>(message,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFounfException.class)
    public ResponseEntity<Message> handleNotFoundException(ResourceNotFounfException e){
        Message message = new Message();
        message.setCode(HttpStatus.NOT_FOUND.value());
        message.setMessage(e.getMessage());
        message.setDate(LocalDate.now());
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Message> handleAlreadyExistException(Exception e){
        Message message = new Message();
        message.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        message.setMessage(e.getMessage());
        message.setDate(LocalDate.now());
        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
