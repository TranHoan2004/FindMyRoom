package com.FindMyRoom.model;

import com.FindMyRoom.model.utils.RoomType;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

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
    private long id;

    @Column(name = "special_items", columnDefinition = "varchar(max)")
    private String specialItem;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Column(nullable = false)
    private String address;

    @Column(columnDefinition = "varchar(max)", name = "available_room")
    private String availableRoom;

    @Column(nullable = false, name = "total_rooms")
    private int totalRooms;

    @Column(nullable = false, name = "number_of_rented_rooms")
    private int numberOfRentedRooms;

    @Column(nullable = false)
    @Min(5)
    @Max(100)
    private int area;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "boardingHouse")
    private List<Booking> bookings;
}