package Service;

import Model.Note;
import Repo.NoteRepository;
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
        Note createdNote = noteRepository.save(newNote);
        return createdNote;
    }

    public Optional<Note> getNoteById(UUID id){
        return noteRepository.findNoteByVisibleId(id);
    }

    public Optional<Note> editNoteById(UUID id, Note newNote){
        Optional<Note> note = noteRepository.findNoteByVisibleId(id);
            Note updatedNote = note.get();
            updatedNote.setTitle(newNote.getTitle());
            updatedNote.setLast_modified(newNote.getDate_created());
            updatedNote.setContent(newNote.getContent());
            updatedNote.setTags(newNote.getTags());

            noteRepository.save(updatedNote);
            return note;
    }
    public void deleteById(UUID id){
        noteRepository.deleteNoteByVisibleId(id);
    }
}
