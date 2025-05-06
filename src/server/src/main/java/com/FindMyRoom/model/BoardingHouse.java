package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BoardingHouse")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "special_items")
    String specialItem;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    RoomType type;

    @Column(nullable = false)
    String address;

    @Column(columnDefinition = "LONGTEXT", name = "available_room")
    String availableRoom;

    @Column(nullable = false, name = "total_rooms")
    int totalRooms;

    @Column(nullable = false, name = "number_of_rented_rooms")
    int numberOfRentedRooms;

    @Column(nullable = false)
    @Min(5)
    @Max(100)
    int area;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    String media;

    @Column(nullable = false, name = "star", columnDefinition = "INT DEFAULT 0")
    @Min(0)
    @Max(5)
    int numberOfStar;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    Business business;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "boardingHouse")
    Set<Booking> bookings;
}
