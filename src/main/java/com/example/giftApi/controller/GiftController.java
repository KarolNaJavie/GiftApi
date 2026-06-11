package com.example.giftApi.controller;

import com.example.giftApi.model.CreateGiftCommand;
import com.example.giftApi.model.DTO.GiftDTO;
import com.example.giftApi.repository.GiftRepository;
import com.example.giftApi.service.GiftService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gifts")
public class GiftController {

    private final GiftService giftService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GiftDTO create(@RequestBody @Valid CreateGiftCommand command) {
        return giftService.save(command);
    }
}
