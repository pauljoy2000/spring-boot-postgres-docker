package com.example.dockerintegration.service;

import com.example.dockerintegration.dto.UserDeviceDTO;
import com.example.dockerintegration.entity.Device;
import com.example.dockerintegration.entity.User;
import com.example.dockerintegration.repository.DeviceRepository;
import com.example.dockerintegration.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserDeviceServiceImpl implements UserDeviceService{
    private UserRepository userRepository;
    private DeviceRepository deviceRepository;

    @Autowired
    public UserDeviceServiceImpl(UserRepository userRepository,
                                 DeviceRepository deviceRepository
    ) {
        this.userRepository = userRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> getUserDevices(String userId) {
        User user = userRepository.findById(userId).orElseThrow();
        log.info("Found user - {}", user.getUsername());
        return deviceRepository.findByUser(user).orElseThrow();
    }

    @Override
    public List<Device> saveUserDevices(UserDeviceDTO userDeviceDTO) {
        log.info("Devices found: {}", userDeviceDTO.getDeviceNames().size());
        userDeviceDTO.getDeviceNames().forEach(log::info);
        List<Device> devices = new ArrayList<>();
        User user = userRepository.findById(userDeviceDTO.getUserId()).orElseThrow();
        log.info("Found user with id {} - {}", userDeviceDTO.getUserId(), user.getUsername());
        userDeviceDTO.getDeviceNames().forEach((deviceName) -> {
            log.info("iterating device: {}", deviceName);
            Device device = new Device();
            device.setName(deviceName);
            device.setUser(user);
            devices.add(device);
        });
        log.info("saving devices: {}", devices.size());
        return deviceRepository.saveAll(devices);
    }
}
