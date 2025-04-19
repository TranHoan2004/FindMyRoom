package com.FindMyRoom.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SliderRequestDTO {
    private long id;
    private byte[] imgURL;
    private Boolean status;
}
