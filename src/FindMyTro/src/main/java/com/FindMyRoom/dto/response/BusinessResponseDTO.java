package com.FindMyRoom.dto.response;

import com.FindMyRoom.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BusinessResponseDTO extends UserDTO {
    private float balance;
    private String permissionNumber;
}
