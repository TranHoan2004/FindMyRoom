package com.FindMyRoom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    String from; // Name of messages source
    String to; // User who will receive notification
    Map<String, String> content = new HashMap<>();
}
