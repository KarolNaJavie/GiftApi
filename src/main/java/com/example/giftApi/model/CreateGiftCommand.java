package com.example.giftApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGiftCommand {

    @NotNull(message = "NULL_VALUE")
    private String name;
    @NotNull(message = "NULL_VALUE")
    private double price;

    public Gift toEntity() {
        return Gift.builder()
                .name(name)
                .price(price)
                .build();
    }

}
