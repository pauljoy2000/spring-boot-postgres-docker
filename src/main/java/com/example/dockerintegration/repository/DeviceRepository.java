package com.example.dockerintegration.repository;

import com.example.dockerintegration.entity.Device;
import com.example.dockerintegration.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    Optional<List<Device>> findByUser(@NonNull User user);
}
