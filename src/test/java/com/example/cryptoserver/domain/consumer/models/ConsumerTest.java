package com.example.cryptoserver.domain.consumer.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsumerTest {
    @Test
    public void constructorTest01(){
        Consumer consumer = new Consumer("Demo", "User", "demo@gmail.com");
        consumer.setId(1L);

        String expected = "1 Demo User demo@gmail.com";
        String actual= consumer.toString();

        Assertions.assertEquals(expected,actual);

    }
}
