package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false)
    @Size(max = 32, min = 8)
    private String password;

    @Column
    private String fullname;

    @Column(name = "phone_number", nullable = false)
    @Size(max = 11, min = 10)
    private String phoneNumber;

    @Column
    private Boolean gender;

    @Column(name = "image_url", columnDefinition = "varbinary(max)")
    private byte[] imgURL;

    @Column(nullable = false)
    private Boolean status;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Admin> admins;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Business> businesses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Booking> bookings;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Cart cart;
}
