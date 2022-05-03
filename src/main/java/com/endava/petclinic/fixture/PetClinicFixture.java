package com.endava.petclinic.fixture;

import com.endava.petclinic.client.OwnerClient;
import com.endava.petclinic.client.PetClient;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.testData.TestDataProvider;
import io.restassured.response.Response;
import lombok.Getter;
import org.apache.http.HttpStatus;


public class PetClinicFixture {

    private OwnerClient ownerClient = new OwnerClient();
    private PetClient petClient = new PetClient();

    private TestDataProvider dataProvider = new TestDataProvider();

    @Getter
    private Owner owner;
    @Getter
    private Pet pet;
    @Getter
    private PetType type;

    public PetClinicFixture createOwner() {
        owner = dataProvider.getOwner();
        Response response = ownerClient.createOwner(owner);
        response.then().statusCode(HttpStatus.SC_CREATED);

        long id = response.body().jsonPath().getLong("id");
        owner.setId(id);

        return this;
    }

    public PetClinicFixture createPet(Owner owner, PetType petType) {
        pet = dataProvider.getPet(owner, petType);
        Response response = petClient.createPet(pet);
        response.then().statusCode(HttpStatus.SC_CREATED);

        long id = response.body().jsonPath().getLong("id");
        pet.setId(id);

        return this;
    }
}
