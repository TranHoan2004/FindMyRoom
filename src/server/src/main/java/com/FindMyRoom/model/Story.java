package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "story")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String link;
    String description;
    byte[] thumbnailImg;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StoryType type;
}
