package com.FindMyRoom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private long userID;
    private long postID;
    private int size;
}
