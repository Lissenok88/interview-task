package org.example.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonTo {
    private String name;
    private String surname;
    private String patronymic;
}
