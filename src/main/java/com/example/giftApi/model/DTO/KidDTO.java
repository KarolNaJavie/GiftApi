package com.example.giftApi.model.DTO;

import com.example.giftApi.model.Gift;
import com.example.giftApi.model.Kid;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class KidDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public static KidDTO fromEntity(Kid kid) {
        return KidDTO.builder()
                .id(kid.getId())
                .firstName(kid.getFirstName())
                .lastName(kid.getLastName())
                .birthDate(kid.getBirthDate())
                .build();
    }
}
