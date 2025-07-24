package dev.sachith.parkingapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ParkingApplicationTests {

    @Test
    void writeDocumentationSnippets() {

        var modules = ApplicationModules.of(ParkingApplication.class)
                .verify();

        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

}
