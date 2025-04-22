package com.FindMyRoom.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    //    @Enumerated(EnumType.STRING)
//    private StoryType type;
    private String link;
    private String description;
    private byte[] thumbnailImg;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StoryType type;
}
