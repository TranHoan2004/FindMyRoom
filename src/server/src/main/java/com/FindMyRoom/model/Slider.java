package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Slider")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Slider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, columnDefinition = "LONGTEXT", name = "image_url")
    byte[] imgURL;

    @Column(nullable = false)
    Boolean status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Employee author;
}
