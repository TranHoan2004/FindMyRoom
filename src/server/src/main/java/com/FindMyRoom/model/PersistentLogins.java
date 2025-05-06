package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persistent_logins")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersistentLogins {
    @Id
    @Column(length = 64)
    String series;

    @Column(length = 64, nullable = false)
    String username;

    @Column(length = 64, nullable = false)
    String token;

    @Column(nullable = false)
    LocalDateTime lastUsed;
}