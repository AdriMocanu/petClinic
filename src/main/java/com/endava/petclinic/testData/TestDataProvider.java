package com.endava.petclinic.testData;

import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestDataProvider {

    private Faker faker = new Faker();

    public Owner getOwner() {
        Owner owner = new Owner();
        owner.setFirstName(faker.name().firstName());
        owner.setLastName(faker.name().lastName());
        owner.setAddress(faker.address().fullAddress());
        owner.setCity(faker.address().city());
        owner.setTelephone(faker.number().digits(faker.number().numberBetween(1, 11)));

        return owner;
    }

    public String getNumberWithDigits(int min, int max) {
        return faker.number().digits(faker.number().numberBetween(min, max));
    }

    public Pet getPet(Owner owner, PetType type) {

        String birthDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        Pet pet = new Pet();
        pet.setName(faker.artist().name());
        pet.setBirthDate(birthDate);
        pet.setOwner(owner);
        pet.setType(type);

        return pet;

    }

    public Visit getVisit(Owner owner, Pet pet, PetType type) {

        String date = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        Visit visit = new Visit();
        visit.setDate(date);
        visit.setDescription(faker.lorem().sentence());
        visit.setPet(pet);

        return visit;
    }
}
