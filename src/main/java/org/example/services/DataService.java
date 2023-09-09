package org.example.services;

import org.example.entities.Account;
import org.example.repositories.DataRepository;
import org.example.to.AccountHistory;
import org.example.to.PersonHistory;
import org.example.util.AccountHistoryUtil;
import org.example.util.PersonUtil;

import java.util.List;

public class DataService {

    private final DataRepository dataRepository = new DataRepository();

    public Object getConvertedData() {

        Account data = dataRepository.findData();
        List<AccountHistory> accountHistory = AccountHistoryUtil.getAccountHistory(data.getBills(), data.getPayments());

        return new PersonHistory(PersonUtil.createTo(data.getPerson()), accountHistory,
                AccountHistoryUtil.getTotalAmount(accountHistory, AccountHistory::getBill),
                AccountHistoryUtil.getTotalAmount(accountHistory, AccountHistory::getPayment));
    }
}
