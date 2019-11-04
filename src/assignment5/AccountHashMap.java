package assignment5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

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

	/**
	 * Time complexity is O(n).
	 */
	public static String displayAccountsWithEqualBalances(Map<String, BankAccount> accountMap) {
		Set<Double> balances = new HashSet<>();
		double sharedValue = Double.MAX_VALUE;

		for (BankAccount ba : accountMap.values()) {
			sharedValue = ba.getBalance();
			if (!balances.add(sharedValue))
				break;
		}

		final double finVal = sharedValue;
		Set<String> accounts = accountMap.keySet();
		accounts.removeIf(key -> !(accountMap.get(key).getBalance() == finVal));
		String answer = String.format("Account numbers %s with equal balance of %d", accounts.toString(),
				(int) sharedValue); // casting for the sake of unit testing
		System.out.println(answer);
		return answer;
	}

	@Test
	public void testEqBal_OneMatch() {
		Map<String, BankAccount> accountMap = new HashMap<>();

		accountMap.put("101", new BankAccount(1000));
		accountMap.put("102", new BankAccount(2500));
		accountMap.put("103", new BankAccount(1000));
		accountMap.put("104", new BankAccount(3000));

		assertEquals("Account numbers [101, 103] with equal balance of 1000",
				displayAccountsWithEqualBalances(accountMap));
	}

	@Test
	public void testEqBal_MultiMatch() {
		Map<String, BankAccount> accountMap = new HashMap<>();

		accountMap.put("101", new BankAccount(1234));
		accountMap.put("102", new BankAccount(2500));
		accountMap.put("103", new BankAccount(1234));
		accountMap.put("104", new BankAccount(1234));
		accountMap.put("105", new BankAccount(1000));
		accountMap.put("106", new BankAccount(6304));
		accountMap.put("107", new BankAccount(1234));
		accountMap.put("108", new BankAccount(3000));

		assertEquals("Account numbers [101, 103, 104, 107] with equal balance of 1234",
				displayAccountsWithEqualBalances(accountMap));
	}

	@Test
	public void testEqBal_AllMatch() {
		Map<String, BankAccount> accountMap = new HashMap<>();

		accountMap.put("101", new BankAccount(4987));
		accountMap.put("102", new BankAccount(4987));
		accountMap.put("103", new BankAccount(4987));

		assertEquals("Account numbers [101, 102, 103] with equal balance of 4987",
				displayAccountsWithEqualBalances(accountMap));
	}

}