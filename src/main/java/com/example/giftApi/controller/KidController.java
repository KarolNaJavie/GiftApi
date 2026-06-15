package com.example.giftApi.controller;


import com.example.giftApi.model.CreateGiftCommand;
import com.example.giftApi.model.CreateKidCommand;
import com.example.giftApi.model.DTO.GiftDTO;
import com.example.giftApi.model.DTO.KidDTO;
import com.example.giftApi.repository.GiftRepository;
import com.example.giftApi.service.GiftService;
import com.example.giftApi.service.KidService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kids")
public class KidController {

    private final KidService kidService;
    private final GiftService giftService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public KidDTO create(@RequestBody @Valid CreateKidCommand command) {
        return kidService.save(command);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public GiftDTO addGift(@RequestBody @Valid CreateGiftCommand command, @PathVariable Long id) {
        return giftService.save(command, id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public KidDTO update(@RequestBody @Valid CreateKidCommand command, @PathVariable Long id) {
        return kidService.update(command, id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<KidDTO> getAll() {
        return kidService.getAllActive();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public KidDTO getKid(@PathVariable Long id) {
        return kidService.findById(id);
    }

    @GetMapping("/{id}/gifts")
    @ResponseStatus(HttpStatus.OK)
    public List<GiftDTO> getGifts(@PathVariable Long id) {
        return giftService.getGifts(id);
    }

    @GetMapping("/{id}/{giftId}")
    @ResponseStatus(HttpStatus.OK)
    public GiftDTO getGiftFromKid(@PathVariable Long id, @PathVariable Long giftId) {
        return giftService.getGiftFromKid(id, giftId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        kidService.delete(id);
    }
}
