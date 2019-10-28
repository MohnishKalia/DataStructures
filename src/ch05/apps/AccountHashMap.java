package ch05.apps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This program demonstrates HashMap
 */

public class AccountHashMap {
	public static void main(String[] args) {
		// Create a HashMap to store Account objects.
		Map<String, BankAccount> accountMap = new HashMap<String, BankAccount>();

		// Create some account objects
		BankAccount johnAccount = new BankAccount(1000);
		BankAccount sallyAccount = new BankAccount(2000);
		BankAccount peterAccount = new BankAccount(3000);
		BankAccount testAccount = new BankAccount(10000);

		// Put some mappings into the HashMap. In each mapping,
		// account number is the key and bankaccount object is the value
		accountMap.put("101", johnAccount);
		accountMap.put("102", sallyAccount);
		accountMap.put("103", peterAccount);
		if (!accountMap.containsKey("103"))
			accountMap.put("103", testAccount);

		// Search for a sample account number
		System.out.println("\nSearching for the account with account number 103");
		BankAccount foundAccount = accountMap.get("103");

		// If the account was found, display the account balance.
		if (foundAccount != null)
			System.out.println(foundAccount.getBalance());
		else
			System.out.println("Account not found in the system");

		// Get a set containing the keys in this map.
		Set<String> keys = accountMap.keySet();

		// Iterate through the keys, printing each one.
		System.out.println("Here are the keys and value pairs:");
		for (String k : keys) {
			System.out.println(k + ":" + accountMap.get(k));
		}

		// Get a collection containing the values.
		Collection<BankAccount> values = accountMap.values();

		// Iterate through the values, printing each one.
		System.out.println("\nHere are the values:");
		for (BankAccount account : values)
			System.out.println(account.getBalance());
	}
}