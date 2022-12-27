package com.example.homeassignmentapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponseDTO {

    private Long id;
    private String username;
    private String email;
    private List<String> roles;


}
