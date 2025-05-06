package com.FindMyRoom.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {
    String from; // Name of messages source
    String to; // User who will receive notification
    Map<String, String> content = new HashMap<>();
}
