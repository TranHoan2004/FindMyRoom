package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String link;

    @Column(nullable = false, columnDefinition = "VARCHAR(5000)")
    String message;

    @Column(nullable = false)
    String title;

    // False for not seen yet, True for having seen
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    Users user;
}