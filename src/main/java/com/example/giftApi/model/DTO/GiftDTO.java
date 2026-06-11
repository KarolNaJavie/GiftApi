package com.example.giftApi.model.DTO;

import com.example.giftApi.model.Gift;
import com.example.giftApi.model.Kid;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GiftDTO {
    private Long id;
    private String name;
    private double price;
    private Long kidId;

    public static GiftDTO fromEntity(Gift gift) {
        return GiftDTO.builder()
                .id(gift.getId())
                .name(gift.getName())
                .price(gift.getPrice())
                .kidId(gift.getKid().getId())
                .build();
    }
}
