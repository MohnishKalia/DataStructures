package assignment5;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AHM {
    /**
     * Time complexity is O(n).
     */
    public static String displayAccountsWithEqualBalances(Map<String, BankAccount> accountMap) {
        // stream over the entries and collect based on shared balances, but map the entries in the list to just the string key instead of the full entry
        Map<Double, List<String>> bankMap = accountMap.entrySet().stream()
                .collect(groupingBy(entry -> entry.getValue().getBalance(), mapping(Map.Entry::getKey, toList())));

        // create a new list that stores the lists with more than one account (ones with matches)
        List<String> matches = new ArrayList<>();
        bankMap.forEach((k, v) -> {
            if (v.size() > 1)
                matches.add(String.format("Account numbers %s with equal balance of %d", v, k.intValue()));
        });

        // concatenate the strings with a slash to separate each equal balance
        String statement = String.join(" / ", matches);
        System.out.println(statement);
        return statement;
    }

    public static void main(String[] args) {
        Map<String, BankAccount> accountMap = new HashMap<>();
        // accountMap.put("101", new BankAccount(1234));
        // accountMap.put("102", new BankAccount(2500));
        // accountMap.put("103", new BankAccount(1234));
        // accountMap.put("104", new BankAccount(1234));
        // accountMap.put("105", new BankAccount(2500));
        // accountMap.put("106", new BankAccount(6304));
        // accountMap.put("107", new BankAccount(1234));
        // accountMap.put("108", new BankAccount(6304));
        // accountMap.put("109", new BankAccount(1101));
        // accountMap.put("110", new BankAccount(2202));
        displayAccountsWithEqualBalances(accountMap);
    }

}