package com.endava.petclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@JsonIgnoreProperties (ignoreUnknown = true)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Owner {

    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private String city;
    @NonNull
    private String telephone;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return firstName.equals(owner.firstName) && lastName.equals(owner.lastName) && address.equals(owner.address) && city.equals(owner.city) && telephone.equals(owner.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, city, telephone);
    }
}
