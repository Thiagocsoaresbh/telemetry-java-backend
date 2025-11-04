package com.fleetview.fleetview_backend.service;

import com.fleetview.fleetview_backend.model.Vehicle;
import com.fleetview.fleetview_backend.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> listAll() {
        return repository.findAll();
    }

    public Vehicle create(Vehicle v) {
        return repository.save(v);
    }
}
