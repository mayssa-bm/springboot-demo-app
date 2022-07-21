package com.notesapp.notes.controller;

import com.notesapp.notes.entity.Note;
import com.notesapp.notes.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebook")
@Slf4j


public class NoteController {

    @Autowired
    private NoteService noteService;


    //check
    //create a new note
    @PostMapping("/note")
    public Note createNote(@RequestBody Note note){
        log.info("createNote method in NoteController");
        return noteService.createNote(note);
    }

    //check
    //show all notes
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        log.info("getAllNotes method in NoteController ");
        return noteService.getAllNotes();
    }

    //check
    //show a specific note based on id
    @GetMapping( value = "/note/{id}")
    public Note getNoteById(@PathVariable("id") Long noteId){
        log.info("getNoteById method in NoteController ");
        return noteService.getNoteById(noteId);


    }
    //check
    //edit a note
    @PutMapping("/note/{id}")
    public Note editNote (@PathVariable("id") Long noteId, @RequestBody Note noteContent){
        Note note = noteService.getNoteById(noteId);

        note.setTitle(noteContent.getTitle());
        note.setBody(noteContent.getBody());
        //edit tag
        Note newEdit = noteService.editNote(note);
        return  newEdit;
    }


    //delete a note
    @DeleteMapping("/note/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long noteId){
        Note note = noteService.getNoteById(noteId);
        noteService.deleteNote(note);
        return ResponseEntity.ok().build();
    }


    //get notes by tags
    //  /notebook/notes?tag=.....
    /*
    @GetMapping("/notes/{tag}")
    public List<Note> getNotesByTag(@RequestParam("tag") String noteTag){
        return noteService.getNotesByTag(noteTag);
    }
    */

    @GetMapping("/notes/{tag}")
    public List<Note> getNotesByTag(@PathVariable("tag") String noteTag){
        return noteService.getNotesByTag(noteTag);
    }


}
