package com.example.giftApi.service;

import com.example.giftApi.model.CreateKidCommand;
import com.example.giftApi.model.DTO.GiftDTO;
import com.example.giftApi.model.DTO.KidDTO;
import com.example.giftApi.model.Gift;
import com.example.giftApi.model.Kid;
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
public class KidService {

    private final KidRepository kidRepository;
    private final GiftRepository giftRepository;

    public KidDTO save(CreateKidCommand command) {
        return KidDTO.fromEntity(kidRepository.save(command.toEntity()));
    }

    public List<KidDTO> getAllActive() {
        return kidRepository.findAllByDeletedFalse().stream().map(KidDTO::fromEntity).toList();
    }

    public void delete(Long id) {
        Kid kid = kidRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException
                        (MessageFormat.format("Kid with id={0} not found", id)));
        kid.setDeleted(true);
        kidRepository.save(kid);
    }

    public KidDTO findById(Long id) {
        return KidDTO.fromEntity(kidRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException
                        (MessageFormat.format("Kid with id={0} not found", id))));

    }

    public KidDTO update(CreateKidCommand command, Long id) {
        Kid kid = kidRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException
                        (MessageFormat.format("Kid with id={0} not found", id)));
        kid.setFirstName(command.getFirstName());
        kid.setLastName(command.getLastName());
        kid.setBirthDate(command.getBirthDate());
        return KidDTO.fromEntity(kidRepository.save(kid));
    }
}
