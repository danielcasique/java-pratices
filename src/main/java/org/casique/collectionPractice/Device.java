package org.casique.collectionPractice;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class Device {

    private UUID id;

    private String name;

    private ZonedDateTime lastRebootTime;

    public Device() {
    }

    public Device(UUID id, String name, ZonedDateTime lastRebootTime) {
        this.id = id;
        this.name = name;
        this.lastRebootTime = lastRebootTime;
    }
}
