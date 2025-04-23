package com.FindMyRoom.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    String from; // Name of messages source
    String to; // User who will receive notification
    Map<String, String> content = new HashMap<>();
}
