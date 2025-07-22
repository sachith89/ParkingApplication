package dev.sachith.parkingapplication.allocation;

import dev.sachith.parkingapplication.event.VehicleEnteredEvent;
import dev.sachith.parkingapplication.event.VehicleExitedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SlotAllocationService {

    private final SlotRepository slotRepository;

    public SlotAllocationService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @EventListener
    public void handleVehicleEntry(VehicleEnteredEvent event) {

        Slot slot = slotRepository.findFirstByAvailableTrue()
                .orElseThrow(() -> new RuntimeException("🚫 No available slots!"));
        slot.setAvailable(false);
        slot.setVehicleNumber(event.vehicleNumber());
        slotRepository.save(slot);

        System.out.printf("Allocated Slot %s to vehicle %s%n", slot.getSlotCode(), event.vehicleNumber());
    }

    @EventListener
    public void handleVehicleExit(VehicleExitedEvent event) {
        slotRepository.findByVehicleNumber(event.vehicleNumber())
                .ifPresentOrElse(slot -> {
                    slot.setAvailable(true); // free the slot
                    slot.setVehicleNumber(null);
                    slotRepository.save(slot);
                    System.out.printf("Freed Slot %s from vehicle %s%n", slot.getSlotCode(), event.vehicleNumber());
                }, () -> {
                    throw new RuntimeException("🚫 No slot found for vehicle " + event.vehicleNumber());
                });
    }


}