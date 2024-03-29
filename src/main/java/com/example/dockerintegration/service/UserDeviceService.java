package com.example.dockerintegration.service;

import com.example.dockerintegration.dto.UserDeviceDTO;
import com.example.dockerintegration.entity.Device;

import java.util.List;

public interface UserDeviceService {
    List<Device> getUserDevices(String userId);
    List<Device> saveUserDevices(UserDeviceDTO userDeviceDTO);
}
