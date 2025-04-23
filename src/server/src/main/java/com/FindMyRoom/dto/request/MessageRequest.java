package com.FindMyRoom.dto.request;

import com.FindMyRoom.model.Message;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private Message message;
    private String title;
}
