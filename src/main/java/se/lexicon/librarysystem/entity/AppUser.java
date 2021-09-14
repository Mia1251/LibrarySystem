package se.lexicon.librarysystem.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    @Column(unique = true)
    private String userName;
    private String passWord;
    private LocalDate regDate;
    @OneToOne(
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private Details userDetails;

    public AppUser() {
    }
}