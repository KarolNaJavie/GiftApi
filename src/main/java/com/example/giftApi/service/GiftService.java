package com.example.giftApi.service;

import com.example.giftApi.model.CreateGiftCommand;
import com.example.giftApi.model.DTO.GiftDTO;
import com.example.giftApi.model.Gift;
import com.example.giftApi.model.Kid;
import com.example.giftApi.model.common.exception.GiftLimitException;
import com.example.giftApi.model.common.exception.GiftNotPresentInListException;
import com.example.giftApi.repository.GiftRepository;
import com.example.giftApi.repository.KidRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;
    private final KidRepository kidRepository;

    public List<GiftDTO> getGifts(Long id) {
        return giftRepository.findAllByKidId(id).stream().map(GiftDTO::fromEntity).toList();
    }

    public GiftDTO getGiftFromKid(Long id, Long giftId) {
       return GiftDTO.fromEntity(giftRepository.findByIdAndKidId(giftId, id));
    }

    public GiftDTO save(CreateGiftCommand command, Long id) {
        if (getGifts(id).size() < 3) {
            Kid kid = kidRepository.findByIdAndDeletedFalse(id)
                    .orElseThrow(() -> new EntityNotFoundException
                            (MessageFormat.format("Kid with id={0} not found", id)));
            Gift gift = command.toEntity();
            gift.setKid(kid);
            return GiftDTO.fromEntity(giftRepository.save(gift));
        } else throw new GiftLimitException("Gift list already full!");
    }
}
