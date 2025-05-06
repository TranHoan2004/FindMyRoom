package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false, length = 6)
    @PositiveOrZero
    float price;

    @Column(nullable = false)
    String content;

    @Column(name = "sale_price", length = 6)
    @PositiveOrZero
    float salePrice;

    @Column(nullable = false, name = "start_date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    LocalDate startDate;

    @Column(nullable = false, name = "end_date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    LocalDate endDate;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0", name = "sold_quantity")
    int soldQuantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    Admin admin;
}
