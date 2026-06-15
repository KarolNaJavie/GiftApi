package com.example.giftApi.repository;

import com.example.giftApi.model.DTO.KidDTO;
import com.example.giftApi.model.Kid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KidRepository extends JpaRepository<Kid, Long> {
    Optional<Kid> findByIdAndDeletedFalse(@NotNull(message = "NULL_VALUE") Long kidId);

    List<Kid> findAllByDeletedFalse();
}
