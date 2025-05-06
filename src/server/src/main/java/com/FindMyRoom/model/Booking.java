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
@Table(name = "Booking")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    Users user;

    @Column(name = "booking_date", nullable = false)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    LocalDate bookingDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    BoardingHouse boardingHouse;
}
