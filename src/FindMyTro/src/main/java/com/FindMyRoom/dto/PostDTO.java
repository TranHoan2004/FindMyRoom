package com.FindMyRoom.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

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
    private List<String> media;
    private Date createdDate;
    private Boolean status;
    private long view;
}
