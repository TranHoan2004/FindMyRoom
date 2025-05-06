package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Business")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Business {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @MapsId
    Users user;

    @Column(nullable = false)
    float balance;

    @Column(nullable = false, length = 20, name = "permission_number")
    String permissionNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "business")
    Set<BoardingHouse> boardingHouseList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "business")
    Set<Post> posts;
}
