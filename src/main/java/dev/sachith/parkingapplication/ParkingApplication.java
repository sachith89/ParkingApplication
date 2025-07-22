package dev.sachith.parkingapplication;

import dev.sachith.parkingapplication.allocation.Slot;
import dev.sachith.parkingapplication.allocation.SlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);
    }

    @Bean
    CommandLineRunner initSlots(SlotRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Slot(null, "A1", true, null));
                repo.save(new Slot(null, "A2", true, null));
                repo.save(new Slot(null, "B1", true, null));
            }
        };
    }

}
