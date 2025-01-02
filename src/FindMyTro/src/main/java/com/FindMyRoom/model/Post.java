package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, columnDefinition = "varbinary(max)", name = "thumbnai_url")
    private byte[] thumbnailURL;

    @Column(name = "special_items", nullable = false)
    private String specialItem;

    @Column(columnDefinition = "varchar(max)", nullable = false)
    private String media;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false, columnDefinition = "bigint default 0", name = "view_count")
    private long view;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private Business business;
}
