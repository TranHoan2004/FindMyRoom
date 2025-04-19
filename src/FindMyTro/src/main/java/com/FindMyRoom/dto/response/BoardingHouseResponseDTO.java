package com.FindMyRoom.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardingHouseResponseDTO {
    private long id;
    private String specialItem;
    private String type;
    private String address;
    private List<String> availableRoom;
    private int totalRoom;
    private int numberOfRentedRooms;
    private int area;
    private int numberOfStar;
}
