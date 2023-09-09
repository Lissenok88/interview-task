package org.example.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountHistory {

    LocalDate date;
    Long bill;
    Long payment;
    String type;
    String comment;

    public AccountHistory(LocalDate date, Long bill, String comment) {
        this(date, bill, null, null, comment);
    }

    public AccountHistory(LocalDate date, Long payment, String type, String comment) {
        this(date, null, payment, type, comment);
    }
}
