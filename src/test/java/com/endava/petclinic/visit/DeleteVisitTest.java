package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeleteVisitTest extends TestBaseClass {

    @Test
    public void shouldDeleteVisit() {
        //GIVEN
        Owner owner = fixture.createOwner()
                .getOwner();

        PetType petType = new PetType();
        petType.setId(1L);

        Pet pet = fixture.createPet(owner, petType)
                .getPet();

        Visit visit = testDataProvider.getVisit(owner, pet, petType);

        Response createVisitResponse = visitClient.createVisit(visit);
        createVisitResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long visitId = createVisitResponse.body().jsonPath().getLong("id");


        //WHEN
        Response response = visitClient.deleteVisitById(visitId);

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }

}
