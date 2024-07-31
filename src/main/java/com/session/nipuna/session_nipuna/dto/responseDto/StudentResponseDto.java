package com.session.nipuna.session_nipuna.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponseDto {

    private Integer id;
    private String name;
    private String address;
    private Boolean isActive;
}
