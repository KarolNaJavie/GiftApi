package com.example.giftApi.service;

import com.example.giftApi.model.CreateGiftCommand;
import com.example.giftApi.model.DTO.GiftDTO;
import com.example.giftApi.model.Gift;
import com.example.giftApi.model.Kid;
import com.example.giftApi.repository.GiftRepository;
import com.example.giftApi.repository.KidRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;
    private final KidRepository kidRepository;

    public GiftDTO save(@Valid CreateGiftCommand command) {
        Kid kid = kidRepository.findByIdAndDeletedFalse(command.getKidId()).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Kid with id={0} not found", command.getKidId())));
        Gift gift = command.toEntity();
        gift.setKid(kid);
        return GiftDTO.fromEntity(giftRepository.save(gift));
    }
}
