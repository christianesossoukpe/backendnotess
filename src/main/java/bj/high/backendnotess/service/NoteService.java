package bj.high.backendnotess.service;

import bj.high.backendnotess.model.Note;
import bj.high.backendnotess.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // Lire toutes les notes
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Lire une note par ID
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    // Créer une nouvelle note
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    // Mettre à jour une note existante
    public Note updateNote(Long id, Note note) {
        if (noteRepository.existsById(id)) {
            note.setId(id);
            return noteRepository.save(note);
        } else {
            throw new IllegalArgumentException("Note " + id + " n'existe pas.");
        }
    }

    // Supprimer une note par ID
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
