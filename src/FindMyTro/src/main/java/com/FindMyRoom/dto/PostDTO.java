package com.FindMyRoom.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private long id;
    private String title;
    private String content;
    private String address;
    private byte[] thumbnailURL;
    private String specialItem;
    private String media;
    private LocalDate createdDate;
    private Boolean status;
    private long view;
}
