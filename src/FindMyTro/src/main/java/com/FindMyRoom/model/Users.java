package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(nullable = false, length = 30, unique = true)
    @Pattern(regexp = "^[A-Za-z](.*)(@)(.{2,})(\\\\.)(.{2,})", message = "Must follow the format <name>@<domain>")
    @Getter
    @Setter
    private String email;

    @Column(nullable = false)
    @Size(max = 32, min = 8)
    @Getter
    private String password;

    @Column
    @Getter
    @Setter
    private String fullname;

    @Column(name = "phone_number", nullable = false)
    @Size(max = 11, min = 10)
    @Getter
    @Setter
    private String phoneNumber;

    @Column
    @Getter
    @Setter
    private Boolean gender;

    @Column(name = "image_url", columnDefinition = "VARBINARY(MAX)")
    @Getter
    @Setter
    private byte[] imgURL;

    @Column(nullable = false)
    @Getter
    @Setter
    private Boolean status;

    @Column(name = "created_date", nullable = false)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Cart cart;

    public List<Admin> getAdmins() {
        return new ArrayList<>(admins);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public List<Business> getBusinesses() {
        return new ArrayList<>(businesses);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Review> getReviews() {
        return new ArrayList<>(reviews);
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
