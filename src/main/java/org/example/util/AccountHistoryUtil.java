package org.example.util;

import lombok.experimental.UtilityClass;
import org.example.entities.Bill;
import org.example.entities.Payment;
import org.example.to.AccountHistory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class AccountHistoryUtil {

    public List<AccountHistory> getAccountHistory(List<Bill> bills, List<Payment> payments) {
        List<AccountHistory> accountHistories = new ArrayList<>();
        accountHistories.addAll(getBills(bills));
        accountHistories.addAll(getPayments(payments));

        return accountHistories.stream().sorted(Comparator.comparing(AccountHistory::getDate))
                .collect(Collectors.toList());
    }

    private List<AccountHistory> getBills(List<Bill> bills) {
        return bills.stream()
                .map(bill -> new AccountHistory(bill.getDate(), bill.getSum(), bill.getComment()))
                .collect(Collectors.toList());
    }

    private List<AccountHistory> getPayments(List<Payment> payments) {
        return payments.stream()
                .map(payment -> new AccountHistory(payment.getDate(), payment.getSum(),
                        payment.getType().getName(), payment.getComment()))
                .collect(Collectors.toList());
    }

    public Long getTotalAmount(List<AccountHistory> listSums, Function<AccountHistory, Long> field) {
        return listSums.stream().map(field).filter(Objects::nonNull).mapToLong(bill -> bill).sum();
    }
}
