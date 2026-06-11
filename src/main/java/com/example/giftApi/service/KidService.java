package com.example.giftApi.service;

import com.example.giftApi.model.CreateKidCommand;
import com.example.giftApi.model.DTO.KidDTO;
import com.example.giftApi.repository.KidRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KidService {

    private final KidRepository kidRepository;

    public KidDTO save(@Valid CreateKidCommand command) {
        return KidDTO.fromEntity(kidRepository.save(command.toEntity()));
    }
}
