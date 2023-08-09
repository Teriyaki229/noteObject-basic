package com.note.noteapp.Repo;

import com.note.noteapp.Model.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NoteRepository extends MongoRepository<Note, ObjectId> {
    Optional<Note> findNoteByVisibleId(UUID visibleId);
    Optional<Note> deleteNoteByVisibleId(UUID visibleId);
}
