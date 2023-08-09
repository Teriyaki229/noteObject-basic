package com.note.noteapp.Controller;

import com.note.noteapp.Model.Note;
import com.note.noteapp.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping("/home")
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteService.allNotes(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") String id){
        return new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> editNote(@PathVariable("id") String id,@RequestBody Note note){
        return new ResponseEntity<>(noteService.editNoteById(id, note), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id){
        noteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
