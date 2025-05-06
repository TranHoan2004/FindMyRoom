package com.FindMyRoom.dto.request;

import com.FindMyRoom.model.Message;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageRequest {
    Message message;
    String title;
}
