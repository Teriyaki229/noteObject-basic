package com.note.noteapp.CustomGlobalExceptions;

import com.note.noteapp.CustomExceptions.NoteIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomGlobalExceptions {
    @ExceptionHandler(NoteIdNotFoundException.class)
    public ResponseEntity<Object> exception(NoteIdNotFoundException e){
        return new ResponseEntity<>(e.getErrorText(), HttpStatus.NOT_FOUND);
    }
}
