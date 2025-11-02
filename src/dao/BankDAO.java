package dao;

import model.Account;
import java.util.HashMap;
import java.util.Map;

public class BankDAO {
    private Map<Integer, Account> accounts = new HashMap<>();

    public void save(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account findByAccountNumber(int accNo) {
        return accounts.get(accNo);
    }
}
