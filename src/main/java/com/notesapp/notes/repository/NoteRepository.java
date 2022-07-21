package com.notesapp.notes.repository;

import com.notesapp.notes.entity.Note;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


    Note findByNoteId(Long noteId);

    List<Note> findByNoteTag(String noteTag);
}
