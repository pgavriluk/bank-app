package pavel.demo;

public class Main {

	public static void main(String[] args) {

		Bank citiBank = new Bank("Citibank");

		citiBank.addBranch("nyc");

		citiBank.addCustomer("nyc", "Pavel", 100.00);
		citiBank.addCustomer("nyc", "Alex", 45.46);
		citiBank.addCustomer("nyc", "Ela", 234.78);

		citiBank.addBranch("nj");

		citiBank.addCustomer("nj", "Grisha", 50.00);

		citiBank.addCustomerTransaction("nyc", "Pavel", 200.00);
		citiBank.addCustomerTransaction("nyc", "Pavel", 10.00);
		citiBank.addCustomerTransaction("nyc", "Ela", 50.00);

		citiBank.listCustomers("nyc", true);
		citiBank.listCustomers("nj", true);

		if (!citiBank.addCustomer("washington", "Brian", 9.88)) {
			System.out.println("Error 'washington' branch does not exist!");
		}

		if (!citiBank.addBranch("nyc")) {
			System.out.println("'nyc' branch already exist!");
		}

		if(!citiBank.addCustomer("nyc", "Pavel", 100)){
			System.out.println("Customer with name 'Pavel' already exist!");
		}
	}


}
