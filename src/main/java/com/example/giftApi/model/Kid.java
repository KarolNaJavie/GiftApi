package com.example.giftApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private boolean deleted = false;
    @OneToMany(mappedBy = "kid")
    private Set<Gift> gifts;
    private Integer gifstNumber = 0;
}
