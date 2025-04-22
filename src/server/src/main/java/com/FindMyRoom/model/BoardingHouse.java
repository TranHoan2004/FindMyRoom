package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;

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
public class BoardingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "special_items")
    private String specialItem;

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private RoomType type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private RoomType type;

    @Column(nullable = false)
    private String address;

    @Column(columnDefinition = "LONGTEXT", name = "available_room")
    private String availableRoom;

    @Column(nullable = false, name = "total_rooms")
    private int totalRooms;

    @Column(nullable = false, name = "number_of_rented_rooms")
    private int numberOfRentedRooms;

    @Column(nullable = false)
    @Min(5)
    @Max(100)
    private int area;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String media;

    @Column(nullable = false, name = "star", columnDefinition = "INT DEFAULT 0")
    @Min(0)
    @Max(5)
    private int numberOfStar;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "boardingHouse")
    private Set<Booking> bookings;
}
