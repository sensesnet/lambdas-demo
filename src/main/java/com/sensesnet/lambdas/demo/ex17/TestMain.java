package com.sensesnet.lambdas.demo.ex17;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summarizingLong;

public class TestMain {

    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(5, 10, 20, 50).parallel();
        String str = s.collect(Collectors.reducing(
                " ",
                x -> Integer.toString(x),
                (s1, s2) -> s1 + s2));
        System.out.println(str);


        Stream<Integer> s2 = Stream.of(5, 10, 20);
        Integer i = s2.collect(Collectors.reducing(3, (integer, integer2)
                -> integer2 * integer));
        System.out.println(i);

        Stream<Integer> s3 = Stream.of(5, 10, 20, 50).parallel();
        String str2 = s3.collect(Collectors.reducing(
                " | ",
                x -> Integer.toString(x),
                (m1, m2) -> m1 + m2));
        System.out.println(str2);


        /*
        Write a collector that evaluates the product of squares of integer numbers in a Stream<Integer>.
        Important. You should write only the collector in any valid formats but without ; on the end.
         */
        Stream<Integer> s4 = Stream.of(0, 1, 2, 3).parallel();
        Long val = s4.collect(Collectors.reducing(1L, Integer::longValue, (a, b) -> a * b * b));
        System.out.println(val);



        /*
        Write a collector that partitions all words in a stream into two groups: palindromes (true) and usual words (false).
        The collector should return Map<Boolean, List<String>>. All input words will be in the same case (lower).
         */

        String[] words = {"level", "bbaa", "ac"};
        Map<Boolean, List<String>> palindromeOrNoMap =
                Arrays.stream(words)
                        .collect(Collectors.partitioningBy(a -> new StringBuilder(a).reverse().toString().equals(a)));
        //Collectors.partitioningBy(w -> w.contentEquals(new StringBuilder(w).reverse()))

        System.out.println(palindromeOrNoMap);



        /*
        You have two classes:
        Account: number: String, balance: Long
        Transaction: uuid: String, sum: Long, account: Account
        Both classes have getters for all fields with the corresponding names (getNumber(), getSum(), getAccount() and so on).
        Write a collector that calculates the total sum of transactions (long type, not integer)
        by each account (i.e. by account number). The collector will be applied to a stream of transactions.

        Classes Transaction and Account will be available during testing. You can create your own classes for local testing.

        Important. You should write only the collector in any valid formats but without ; on the end.
        It will be passed as an argument to the collect() method of a stream as shown below.
         */

        List<Transaction> transactions = new ArrayList<>();
        Map<String, Long> totalSumOfTransByEachAccount =
                transactions.stream()
                        .collect(Collectors.toMap(x -> x.getAccount().getNumber(), Transaction::getSum, (a, b) -> a + b));

        //groupingBy(t -> t.getAccount().getNumber(), summingLong(Transaction::getSum))


        /*
        There is a LogEntry class for monitoring user activity on your site. The class has three fields:
        created: Date - the date of creating log entry
        login: String - a user login
        url: String - a url that the user clicked
        The class have getters for all fields with the corresponding names (getCreated(), getLogin(), getUrl()).

        Write a collector that calculates how many times was clicked each url by users. The collector will be applied to a stream of log entries for creating a map: url -> click count.

        The class LogEntry will be available during testing. You can create your own classes for local testing.

        Important. You should write only the collector in any valid formats but without ; on the end.
        It will be passed as an argument to the collect() method of a stream as shown below.
         */
    }

    class Transaction {

        String uuid;
        Long sum;
        Account account;

        public Transaction(String uuid, Long sum, Account account) {
            this.uuid = uuid;
            this.sum = sum;
            this.account = account;
        }

        public String getUuid() {
            return uuid;
        }

        public Long getSum() {
            return sum;
        }

        public Account getAccount() {
            return account;
        }
    }

    class Account {
        String number;
        Long balance;

        public Account(String number, Long balance) {
            this.number = number;
            this.balance = balance;
        }

        public Long getBalance() {
            return balance;
        }

        public String getNumber() {
            return number;
        }
    }
}
