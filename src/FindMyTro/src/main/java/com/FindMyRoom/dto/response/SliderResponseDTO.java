package com.FindMyRoom.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SliderResponseDTO {
    private long id;
    private byte[] imgURL;
    private Boolean status;
}
