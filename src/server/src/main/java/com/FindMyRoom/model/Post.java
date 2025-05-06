package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Post")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String content;

    @Column(nullable = false)
    String address;

    @Column(nullable = false, columnDefinition = "LONGTEXT", name = "thumbnai_url")
    byte[] thumbnailURL;

    @Column(name = "special_items", nullable = false)
    String specialItem;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    String media;

    @Column(name = "created_date", nullable = false)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd", fallbackPatterns = {"yyyy/MM/dd", "dd-MM-yyyy", "dd/MM/yyyy"})
    @Temporal(TemporalType.DATE)
    LocalDate createdDate;

    @Column(nullable = false)
    Boolean status;

    @Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0", name = "view_count")
    Long view;

    @Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0", name = "post_like")
    Long like;

    @Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0", name = "post_share")
    Long share;

    Set<String> comments;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    Users user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    Business business;
}
