package com.note.noteapp.CustomExceptions;

import lombok.Getter;
@Getter
public class NoteIdNotFoundException extends RuntimeException {
    private final String errorText;
    public NoteIdNotFoundException(String id){
        errorText="Note ID: \"" +id+ "\" not found";
    }
}
