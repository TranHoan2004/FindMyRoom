package com.FindMyRoom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO extends UserDTO {
    private long adminID;
}
