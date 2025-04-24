package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
// HoanTX
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false, columnDefinition = "VARCHAR(5000)")
    private String message;

    @Column(nullable = false)
    private String title;

    // False for not seen yet, True for having seen
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
}