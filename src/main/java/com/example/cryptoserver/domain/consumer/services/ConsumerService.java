package com.example.cryptoserver.domain.consumer.services;

import com.example.cryptoserver.domain.consumer.models.Consumer;
import com.example.cryptoserver.domain.core.exceptions.ResourceCreationException;
import com.example.cryptoserver.domain.core.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ConsumerService {
   Consumer create(Consumer consumer) throws ResourceCreationException;
   Consumer getById(Long id) throws ResourceNotFoundException;
   Consumer getByEmail(String email) throws ResourceNotFoundException;
   List<Consumer> getAll();
   Consumer update(Long id, Consumer consumerDetail) throws ResourceNotFoundException;
   void delete(Long id);

}
