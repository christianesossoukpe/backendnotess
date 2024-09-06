package bj.high.backendnotess.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Identifiant")
    private Long id;

    @Column(name = "titre", nullable = false)
    private String title;

    @Column(name = "contenu", nullable = false)
    private String content;

    @Column(name = "category")
    private String category;

    // Relation OneToMany: Une note peut avoir plusieurs sous-notes 
    @OneToMany(mappedBy = "parentNote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> subNotes;

    // Relation ManyToOne: Une sous-note appartient à une note parent
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Note parentNote;
}
