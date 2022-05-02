package com.endava.petclinic;

import com.endava.petclinic.client.OwnerClient;
import com.endava.petclinic.client.PetClient;
import com.endava.petclinic.fixture.PetClinicFixture;
import com.endava.petclinic.testData.TestDataProvider;
import extension.TestReporterExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestReporterExtension.class)
public class TestBaseClass {

    protected OwnerClient ownerClient = new OwnerClient();
    protected PetClient petClient = new PetClient();
    protected TestDataProvider testDataProvider = new TestDataProvider();

    protected PetClinicFixture fixture = new PetClinicFixture();

}
