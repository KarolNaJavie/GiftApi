package com.example.giftApi.controller;


import com.example.giftApi.model.CreateKidCommand;
import com.example.giftApi.model.DTO.KidDTO;
import com.example.giftApi.service.KidService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gifts")
public class KidController {

    private final KidService kidService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KidDTO create(@RequestBody @Valid CreateKidCommand command) {
        return kidService.save(command);
    }
}
