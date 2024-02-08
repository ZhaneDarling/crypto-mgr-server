package com.example.cryptoserver.domain.consumer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity//JPA to save the database
@NoArgsConstructor//Non argument constructor
@RequiredArgsConstructor//parameterized constructor
@Data//getter && setter
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;

    public String toString(){
        return String.format("%d %s %s %s", id, firstName, lastName, email);
    }
}
