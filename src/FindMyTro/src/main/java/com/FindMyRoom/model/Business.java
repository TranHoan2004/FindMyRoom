package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Business")
public class Business {
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @MapsId
    private Users user;

    @Column(nullable = false)
    private float balance;

    @Column(nullable = false, length = 20, name = "permission_number")
    private String permissionNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "business")
    private List<BoardingHouse> boardingHouseList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "business")
    private List<Post> posts;
}
