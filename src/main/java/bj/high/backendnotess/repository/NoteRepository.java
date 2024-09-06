package bj.high.backendnotess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.high.backendnotess.model.Note;

public interface NoteRepository extends JpaRepository<Note,Long> {
    
}
