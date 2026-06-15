package com.example.giftApi.repository;

import com.example.giftApi.model.DTO.GiftDTO;
import com.example.giftApi.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {
    List<Gift> findAllByKidId(long id);

    Gift findByIdAndKidId(Long id, Long kidId);
}
