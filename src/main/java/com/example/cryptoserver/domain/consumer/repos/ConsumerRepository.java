package com.example.cryptoserver.domain.consumer.repos;

import com.example.cryptoserver.domain.consumer.models.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Optional<Consumer> findByEmail(String email);
}
