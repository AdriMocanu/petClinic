package com.endava.petclinic.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Visit {

    private Long id;
    private String date;
    private String description;
    private Pet pet;


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
        Visit that = (Visit) o;
        return Objects.equals(date, that.date) && Objects.equals(description, that.description) && Objects.equals(pet, that.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, description, pet);
    }
}
