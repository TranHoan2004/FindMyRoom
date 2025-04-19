package com.FindMyRoom.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponseDTO {
    private long userID;
    private long postID;
    private int size;
}
