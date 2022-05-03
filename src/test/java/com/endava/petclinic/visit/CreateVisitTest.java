package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateVisitTest extends TestBaseClass {

    @Test
    public void shouldCreateVisit() {

        //GIVEN
        Owner owner = fixture.createOwner()
                .getOwner();

        PetType petType = new PetType();
        petType.setId(1L);

        Pet pet = fixture.createPet(owner, petType)
                .getPet();

        Visit visit = testDataProvider.getVisit(owner, pet, petType);

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode(HttpStatus.SC_CREATED)
                .body("id", is(notNullValue()));

    }

    @Test
    public void shouldFailToCreateVisitGivenEmptyDate() {

        //GIVEN
        Owner owner = fixture.createOwner()
                .getOwner();

        PetType petType = new PetType();
        petType.setId(1L);

        Pet pet = fixture.createPet(owner, petType)
                .getPet();

        Visit visit = testDataProvider.getVisit(owner, pet, petType);
        visit.setDate("");

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void shouldFailToCreateVisitGivenWrongDateFormat() {

        //GIVEN
        Owner owner = fixture.createOwner()
                .getOwner();

        PetType petType = new PetType();
        petType.setId(1L);

        Pet pet = fixture.createPet(owner, petType)
                .getPet();

        Visit visit = testDataProvider.getVisit(owner, pet, petType);
        visit.setDate("2553453/105353/20225353");

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
