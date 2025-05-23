package com.FindMyRoom.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationResponseDTO {
    String id;
    String link;
    String message;
    String title;
    boolean status;
}
