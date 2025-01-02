package com.FindMyRoom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SliderDTO {
    private long id;
    private byte[] imgURL;
    private Boolean status;
}
