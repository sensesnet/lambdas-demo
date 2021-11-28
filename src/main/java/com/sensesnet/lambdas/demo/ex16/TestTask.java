package com.sensesnet.lambdas.demo.ex16;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
You have two classes:

Transaction: uuid: String,  state: State (CANCELED, FINISHED, PROCESSING), sum: Long, created: Date
Account: number: String, balance: Long, transactions: List<Transaction>
Both classes have getters for all fields with the corresponding names (getState(), getSum(), getTransactions() and so on).
Write a method using Stream API that calculates the total sum of canceled transactions for all non-empty accounts (balance > 0). Perhaps, flatMap method can help you to implement it.


Classes Transaction, Account and enum State will be available during testing. You can define your own classes for local testing.

Important. Use the given template for your method. Pay attention to type of an argument and the returned value. Please, use only Stream API, no cycles.

Examples: there are 2 accounts (in JSON notation) below. The result is 10 000.

[
{
"number": "1001",
"balance": 0,
"transactions": [
  {
    "uuid": "774cedda-9cde-4f53-8bc2-5b4d4859772a",
    "state": "CANCELED",
    "sum": 1000,
    "created": "2016.12.12 18:30:05"
  }
]
},
{
"number": "1002",
"balance": 8000,
"transactions": [
  {
    "uuid": "337868a7-f469-43c0-9042-3422ce37ee26a",
    "state": "FINISHED",
    "sum": 8000,
    "created": "2016.12.12 17:30:55"
  },
  {
    "uuid": "f8047f86-89e7-4226-8b75-74c55a4d7e31",
    "state": "CANCELED",
    "sum": 10000,
    "created": "2016.12.12 18:10:18"
  }
]
}
]
 */

class TestTask {

    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */



    public static void main(String[] args) {
        final Transaction t1 = new Transaction(State.CANCELED, 1000L);
        final Account a1 = new Account(0L, Collections.singletonList(t1));

        final Transaction t2 = new Transaction(State.FINISHED, 8000L);
        final Transaction t3 = new Transaction(State.CANCELED, 10_000L);
        final Account a2 = new Account(8000L, Arrays.asList(t2, t3));

        final Transaction t4 = new Transaction(State.FINISHED, 9000L);
        final Transaction t5 = new Transaction(State.CANCELED, 3000L);
        final Account a3 = new Account(8000L, Arrays.asList(t4, t5));

        // 13000 expected
        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(Arrays.asList(a1, a2, a3)));

    }

    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() > 0L)
                .flatMap(account -> account.getTransactions().stream()
                        .filter(transaction -> transaction.getState().equals(State.CANCELED)))
                .map(Transaction::getSum).reduce(0L, Long::sum);
    }
}

class Transaction {
    State state;
    Long sum;

    public Transaction(State state, Long sum) {
        this.state = state;
        this.sum = sum;
    }

    public State getState() {
        return state;
    }

    public Long getSum() {
        return sum;
    }
}

class Account {
    Long balance;
    List<Transaction> transactions;

    public Account(Long balance, List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    public Long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

enum State {
    CANCELED,
    FINISHED
}
