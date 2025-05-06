package com.FindMyRoom.model;

import com.FindMyRoom.model.utils.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "Users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 30, unique = true)
    @Setter
    String email;

    @Column(nullable = false)
    @Setter
    String password;

    @Column
    @Setter
    String fullname;

    @Column(name = "phone_number", nullable = false)
    @Setter
    String phoneNumber;

    @Column
    @Setter
    Boolean gender;

    @Column(name = "image_url", columnDefinition = "LONGTEXT")
    @Setter
    byte[] imgURL;

    @Column(nullable = false)
    @Setter
    Boolean status;

    @Column(name = "created_date", nullable = false)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    @Setter
    LocalDate createdDate;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Admin> admins;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Business> businesses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Post> posts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Booking> bookings;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    Cart cart;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    Set<Notification> notifications;
}
