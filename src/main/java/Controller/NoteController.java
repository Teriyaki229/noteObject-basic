package Controller;

import Model.Note;
import Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping("/home")
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<List<Note>>(noteService.allNotes(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<Note>(noteService.createNote(note), HttpStatus.CREATED);
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") UUID id){
        Optional<Note> optionalNote = noteService.getNoteById(id);
        if (optionalNote.isPresent()) return new ResponseEntity<Note>(optionalNote.get(), HttpStatus.OK);
        else return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<Note> editNote(@PathVariable("id") UUID id,@RequestBody Note note){
        Optional<Note> editedNote = noteService.editNoteById(id, note);
        if (editedNote.isPresent()) return new ResponseEntity<>(editedNote.get(), HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") UUID id){
        try{
            noteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
