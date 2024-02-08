package com.example.cryptoserver.domain.consumer.controllers;

import com.example.cryptoserver.domain.consumer.models.Consumer;
import com.example.cryptoserver.domain.consumer.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/consumers")
public class ConsumerController {

    private ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping
    public ResponseEntity <List<Consumer>> getAll(){
        List<Consumer> consumers = consumerService.getAll();
        return new ResponseEntity<>(consumers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Consumer> create(@RequestBody Consumer consumer){
        consumer = consumerService.create(consumer);
        return  new ResponseEntity<>(consumer, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<Consumer> getById(@PathVariable("id") Long id){
        Consumer consumer = consumerService.getById(id);
        return new ResponseEntity<>(consumer, HttpStatus.OK);

    }
    @GetMapping("lookup")
    public ResponseEntity<Consumer> getByEmail(@RequestParam String email){
        Consumer consumer = consumerService.getByEmail(email);
        return new ResponseEntity<>(consumer, HttpStatus.OK);
    }
@PutMapping("{id}")
    public ResponseEntity<Consumer> update(@PathVariable("id") Long id, @RequestBody Consumer consumerDetail){
        consumerDetail = consumerService.update(id, consumerDetail);
        return  new ResponseEntity<>(consumerDetail, HttpStatus.ACCEPTED);
}

@DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        consumerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
