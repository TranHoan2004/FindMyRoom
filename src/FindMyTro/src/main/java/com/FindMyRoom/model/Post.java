package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, columnDefinition = "LONGTEXT", name = "thumbnai_url")
    private byte[] thumbnailURL;

    @Column(name = "special_items", nullable = false)
    private String specialItem;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String media;

    @Column(name = "created_date", nullable = false)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = { "yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy" })
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false, columnDefinition = "bigint default 0", name = "view_count")
    private Long view;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private Business business;
}
