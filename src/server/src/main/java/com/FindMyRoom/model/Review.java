package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Review")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String content;

    @Column(nullable = false, name = "created_date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    LocalDate createdDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    BoardingHouse house;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Users user;
}
