package pavel.demo;

import java.util.ArrayList;

public class Bank {

	// fields
	private String name;
	private ArrayList<Branch> branches;

	public Bank(String name) {
		this.name = name;
		this.branches = new ArrayList<>();
	}

	// methods
	public boolean addBranch(String branchName) {
		if (findBranch(branchName) == null) {
			this.branches.add(new Branch(branchName));
			return true;
		}
		return false;
	}

	public boolean addCustomer(String branchName, String customerName, double initialAmount) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			return branch.addNewCustomer(customerName, initialAmount);
		}
		return false;
	}

	public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			return branch.addCustomerTransaction(customerName, amount);
		}
		return false;
	}

	private Branch findBranch(String branchName) {
		for (int i = 0; i < this.branches.size(); i++) {
			Branch checkedBranch = this.branches.get(i);
			if (checkedBranch.getName().equals(branchName)) {
				return checkedBranch;
			}
		}
		return null;
	}

	public boolean listCustomers(String branchName, boolean showTransactions) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			System.out.println("Customers for branch " + branch.getName() + " are:");
			ArrayList<Customer> branchCustomers = branch.getCustomers();
			branchCustomers.forEach(customer -> {
				System.out.println("Customer: [" + customer.getName() + "]");
				if (showTransactions) {
					System.out.println("Transactions");
					ArrayList<Double> transactions = customer.getTransactions();
					transactions.forEach(transaction -> System.out.println("Transaction is: " + transaction));
				}
			});
			return true;
		}
		return false;
	}

}
