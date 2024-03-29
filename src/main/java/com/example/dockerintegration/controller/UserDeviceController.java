package com.example.dockerintegration.controller;

import com.example.dockerintegration.dto.UserDeviceDTO;
import com.example.dockerintegration.entity.Device;
import com.example.dockerintegration.service.UserDeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserDeviceController {

    private UserDeviceService userDeviceService;

    @Autowired
    public UserDeviceController(UserDeviceService userDeviceService) {
        this.userDeviceService = userDeviceService;
    }

    @GetMapping("{id}/device")
    public ResponseEntity<?> getUserDevices(
            @PathVariable(name = "id") String userId
    ) {
        log.info("START - GET api/v1/user/{}/device", userId);
        var response = userDeviceService.getUserDevices(userId);
        log.info("END - GET api/v1/user/{}/device", userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("device")
    public ResponseEntity<?> saveUserDevices(
            @RequestBody UserDeviceDTO userDeviceDTO
    ) {
        log.info("START - POST api/v1/user/device");
        List<Device> devices = userDeviceService.saveUserDevices(userDeviceDTO);
        log.info("END - POST api/v1/user/device");
        return ResponseEntity.status(HttpStatus.OK).body(devices);
    }
}
