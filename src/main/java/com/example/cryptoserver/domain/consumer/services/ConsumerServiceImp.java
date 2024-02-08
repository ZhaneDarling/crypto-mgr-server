package com.example.cryptoserver.domain.consumer.services;

import com.example.cryptoserver.domain.consumer.models.Consumer;
import com.example.cryptoserver.domain.core.exceptions.ResourceCreationException;
import com.example.cryptoserver.domain.core.exceptions.ResourceNotFoundException;
import com.example.cryptoserver.domain.consumer.repos.ConsumerRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerServiceImp implements ConsumerService {
    private ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerServiceImp(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @Override
    public Consumer create(Consumer consumer) throws ResourceCreationException {
        Optional<Consumer> optional = consumerRepository.findByEmail(consumer.getEmail());
        if(optional.isPresent())
            throw  new ResourceCreationException("User with Email exist" + consumer.getEmail());
        consumer = consumerRepository.save(consumer);
        return consumer;
    }

    @Override
    public Consumer getById(Long id) throws ResourceNotFoundException {
        Consumer consumer = consumerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Employee with id" + id));
        return consumer;
    }

    @Override
    public Consumer getByEmail(String email) throws ResourceNotFoundException {
        Consumer consumer = consumerRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Employee with email" + email));
        return consumer;
    }

    @Override
    public List<Consumer> getAll() {
        return consumerRepository.findAll();
    }

    @Override
    public Consumer update(Long id, Consumer consumerDetail) throws ResourceNotFoundException {
        Consumer consumer = getById(id);
        consumer.setFirstName(consumerDetail.getFirstName());
        consumer.setLastName(consumerDetail.getLastName());
        consumer.setEmail(consumerDetail.getEmail());
        consumer = consumerRepository.save(consumer);
        return consumer;
    }

    @Override
    public void delete(Long id) {
        Consumer consumer = getById(id);
        consumerRepository.delete(consumer);
    }
}
