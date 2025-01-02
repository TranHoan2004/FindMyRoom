package com.FindMyRoom.utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListToStringConverter {
    // convert from List<String> to String in order to save to the database
    public String convertToString(@NotNull List<String> attribute) {
        StringBuilder sb = new StringBuilder();
        for (String str : attribute) {
            if (attribute.indexOf(str) == attribute.size() - 1) {
                sb.append(str);
            } else {
                sb.append(str).append(", ");
            }
        }
        return sb.toString();
    }

    // convert from String in the database to List<String>
    public List<String> convertToList(@NotNull String dbData) {
        String[] element = dbData.split(", ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, element);
        return list;
    }
}
