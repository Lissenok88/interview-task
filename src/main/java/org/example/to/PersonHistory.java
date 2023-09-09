package org.example.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonHistory {

    PersonTo person;
    List<AccountHistory> pivotTable;
    Long sumBill;
    Long sumPayment;
}
