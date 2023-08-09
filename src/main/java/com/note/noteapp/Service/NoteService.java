package com.note.noteapp.Service;

import com.note.noteapp.CustomExceptions.NoteIdNotFoundException;
import com.note.noteapp.Model.Note;
import com.note.noteapp.Repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> allNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note newNote) {
        newNote.setVisibleId(UUID.randomUUID());
        return noteRepository.save(newNote);
    }

    public Note getNoteById(String id) {
        try {
            Optional<Note> note = noteRepository.findNoteByVisibleId(UUID.fromString(id));
            if (note.isEmpty()) {
                throw new NoteIdNotFoundException(id);
            } else return noteRepository.findNoteByVisibleId(UUID.fromString(id)).get();
        } catch (IllegalArgumentException e) {
            throw new NoteIdNotFoundException(id);
        }
    }

    public Note editNoteById(String id, Note newNote) {
        try {
            Optional<Note> note = noteRepository.findNoteByVisibleId(UUID.fromString(id));
            if (note.isPresent()) {
                Note updatedNote = note.get();

                updatedNote.setTitle(newNote.getTitle());
                updatedNote.setLast_modified(newNote.getDate_created());
                updatedNote.setContent(newNote.getContent());
                updatedNote.setTags(newNote.getTags());

                noteRepository.save(updatedNote);
                return updatedNote;
            } else throw new NoteIdNotFoundException(id);
        }catch (IllegalArgumentException e){
            throw new NoteIdNotFoundException(id);
        }
    }
    public void deleteById(String id){
        try{
        Optional<Note> note = noteRepository.deleteNoteByVisibleId(UUID.fromString(id));
        if (note.isEmpty()) throw new NoteIdNotFoundException(id);
        }
        catch (IllegalArgumentException e){
            throw new NoteIdNotFoundException(id);
        }
    }
}
