package com.FindMyRoom.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EmployeeDTO extends UserDTO {
    private long adminID;
}
