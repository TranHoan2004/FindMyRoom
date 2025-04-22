package com.FindMyRoom.dto.request;

import com.FindMyRoom.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private Message message;
    private String title;
}
