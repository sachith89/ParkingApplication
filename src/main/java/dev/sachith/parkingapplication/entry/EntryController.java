package dev.sachith.parkingapplication.entry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }
    // private ExitService exitService;

    @PostMapping("/entry")
    public ResponseEntity<String> entry(@RequestParam String vehicleNumber) {
        entryService.vehicleEntry(vehicleNumber);
        return ResponseEntity.ok("Vehicle entered: " + vehicleNumber);
    }

    @PostMapping("/exit")
    public ResponseEntity<String> exit(@RequestParam String vehicleNumber) {
        //  exitService.vehicleExit(vehicleNumber);
        return ResponseEntity.ok("Vehicle exited: " + vehicleNumber);
    }
}
