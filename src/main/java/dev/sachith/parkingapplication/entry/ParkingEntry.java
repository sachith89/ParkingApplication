package dev.sachith.parkingapplication.entry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingEntry {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String vehicleNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private boolean active;
}
