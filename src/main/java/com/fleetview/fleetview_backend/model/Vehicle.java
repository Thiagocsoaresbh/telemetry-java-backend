package com.fleetview.fleetview_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String plate;

    private String alias;
    private String model;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ONLINE, OFFLINE, IDLE, MOVING
    }
}
