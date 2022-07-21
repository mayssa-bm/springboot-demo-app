package com.notesapp.notes.service;

import com.notesapp.notes.entity.Note;
import com.notesapp.notes.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        log.info("createNote in NoteService");
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        log.info("getAllNotes in NoteService");
        return  noteRepository.findAll();
    }

    public Note getNoteById(Long noteId) {
        log.info("getNoteById in NoteService");
        return noteRepository.findByNoteId(noteId);
    }


    public Note editNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }


    public List<Note> getNotesByTag(String noteTag) {
        return noteRepository.findByNoteTag(noteTag);
    }
}
