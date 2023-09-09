package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private Person person;

    // Выставленные счета на списание
    private List<Bill> bills;

    // Операции пополнения;
    private List<Payment> payments;
}
