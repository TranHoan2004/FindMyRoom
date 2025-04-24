package com.FindMyRoom.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class NotificationResponseDTO {
    private String id;
    private String link;
    private String message;
    private String title;
    private boolean status;
}
