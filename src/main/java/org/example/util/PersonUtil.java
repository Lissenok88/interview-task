package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.entities.Person;
import org.example.to.PersonTo;

@UtilityClass
public class PersonUtil {
    public PersonTo createTo(Person person) {
        return new PersonTo(person.getName(), person.getSurname(), person.getPatronymic());
    }
}
