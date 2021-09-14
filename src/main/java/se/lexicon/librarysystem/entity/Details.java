package se.lexicon.librarysystem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailsId;
    @Column(unique = true)
    private String email;
    private String name;
    private LocalDate birthDate;

    public Details() {
    }

    public Details(int detailsId, String email, String name, LocalDate birthDate) {
        this.detailsId = detailsId;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
