package com.example.dockerintegration.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDeviceDTO {
    private String userId;
    private List<String> deviceNames;
}
