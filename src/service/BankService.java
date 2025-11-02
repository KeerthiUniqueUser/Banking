package service;

import dao.BankDAO;
import model.Account;
import java.util.Random;

public class BankService {
    private BankDAO bankDAO = new BankDAO();
    private Random random = new Random();

    public Account createAccount(String name, String pin) {
        int accNo = 1000 + random.nextInt(9000);
        Account acc = new Account(accNo, name, pin, 0.0);
        bankDAO.save(acc);
        return acc;
    }

    public Account login(int accNo, String pin) {
        Account acc = bankDAO.findByAccountNumber(accNo);
        if (acc != null && acc.getPin().equals(pin)) {
            return acc;
        }
        return null;
    }

    public void deposit(Account acc, double amount) {
        acc.deposit(amount);
    }

    public boolean withdraw(Account acc, double amount) {
        if (acc.getBalance() >= amount) {
            acc.withdraw(amount);
            return true;
        }
        return false;
    }
}
