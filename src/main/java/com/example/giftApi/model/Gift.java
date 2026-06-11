package com.example.giftApi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Gift {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name = "kid_id")
    private Kid kid;
}
