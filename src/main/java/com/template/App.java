package com.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class App {

    Map<String, Integer> accounts = new HashMap<>();

    public void createAccount(String name, int balance) {
        accounts.put(name, balance);
    }

    public void transfer(String initialAccount, String targetAccount, Integer amount) {
        if (accounts.containsKey(initialAccount) && accounts.containsKey(targetAccount) && amount>0 && amount<=accounts.get(initialAccount)) {
            accounts.put(targetAccount, accounts.get(targetAccount) + amount);
            accounts.put(initialAccount, accounts.get(initialAccount) - amount);
        }
    }

    public void deposit(String targetAccount, Integer amount) {
        if (accounts.containsKey(targetAccount) && amount>0) {
            accounts.put(targetAccount, accounts.get(targetAccount) + amount);
        }
    }

    public void withdraw(String targetAccount, Integer amount) {
        if (accounts.containsKey(targetAccount) && amount>0 && amount<=accounts.get(targetAccount)) {
            accounts.put(targetAccount, accounts.get(targetAccount) - amount);
        }
    }

}
