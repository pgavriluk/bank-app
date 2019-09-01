package pavel.demo;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class Customer {

	// fields
	private String name;
	private ArrayList<Double> transactions;

	// constructors
	public Customer(String name, double initialAmount) {
		this.name = name;
		this.transactions = new ArrayList<Double>();
		addTransaction(initialAmount);
	}

	public void addTransaction(double amount) {
		this.transactions.add(amount);
	}

}
