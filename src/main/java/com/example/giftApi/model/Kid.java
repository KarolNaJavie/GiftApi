package com.example.giftApi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Kid {

    //imię, nazwisko, data urodzenia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean deleted = false;
    @OneToMany(mappedBy = "kid")
    private Set<Gift> gifts;
}
