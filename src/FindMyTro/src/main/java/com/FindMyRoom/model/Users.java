package com.FindMyRoom.model;

import com.FindMyRoom.model.utils.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30, unique = true)
    @Pattern(regexp = "^[A-Za-z](.*)(@)(.{2,})(\\\\.)(.{2,})", message = "Must follow the format <name>@<domain>")
    @Setter
    private String email;

    @Column(nullable = false)
    @Size(max = 32, min = 8)
    @Setter
    private String password;

    @Column
    @Setter
    private String fullname;

    @Column(name = "phone_number", nullable = false)
    @Size(max = 11, min = 10)
    @Setter
    private String phoneNumber;

    @Column
    @Setter
    private Boolean gender;

    @Column(name = "image_url", columnDefinition = "VARBINARY(MAX)")
    @Setter
    private byte[] imgURL;

    @Column(nullable = false)
    @Setter
    private Boolean status;

    @Column(name = "created_date", nullable = false)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    @Setter
    private Date createdDate;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

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

}
