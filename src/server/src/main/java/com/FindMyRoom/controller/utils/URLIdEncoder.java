package com.FindMyRoom.controller.utils;

import java.util.Base64;

public class URLIdEncoder {
    public static String encodeId(long id) {
        return Base64.getUrlEncoder().encodeToString(String.valueOf(id).getBytes());
    }

    public static long decodeId(String encodedId) {
        byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedId);
        return Integer.parseInt(new String(decodedBytes));
    }
}
