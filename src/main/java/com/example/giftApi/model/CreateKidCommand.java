package com.example.giftApi.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateKidCommand {
    @NotNull(message = "NULL_VALUE")
    private String firstName;
    @NotNull(message = "NULL_VALUE")
    private String lastName;
    @NotNull(message = "NULL_VALUE")
    private LocalDate birthDate;

    public Kid toEntity() {
        return Kid.builder()
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .build();
    }
}
