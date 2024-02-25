import java.util.Scanner;

class Customer {
    int accountNo;
    String customerName;
    double accountBalance;

    // Parameterized constructor
    public Customer(int accountNo, String customerName, double accountBalance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }
}

class Transactions {
    Customer[] data; 

    
    public Transactions() {
        
        data = new Customer[3];
        data[0] = new Customer(1234, "Umesh", 10000);
        data[1] = new Customer(5678, "suraj", 20000);
        data[2] = new Customer(91011, "Suyog", 15000);
    }

    public void deposit(int accountNo, double amount) {
        for (Customer customer : data) {
            if (customer.accountNo == accountNo) {
                customer.accountBalance += amount;
                System.out.println("Amount deposited successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void withdraw(int accountNo, double amount) {
        for (Customer customer : data) {
            if (customer.accountNo == accountNo) {
                
                if (customer.accountBalance >= amount) {
                    customer.accountBalance -= amount;
                    System.out.println("Amount withdrawn successfully.");
                } else {
                    System.out.println("Insufficient funds.");
                }
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void checkBalance(int accountNo) {
        for (Customer customer : data) {
            if (customer.accountNo == accountNo) {
                System.out.println("Account Balance for " + customer.customerName + ": " + customer.accountBalance);
                return;
            }
        }
        System.out.println("Customer not found.");
    }
}

public class MainApp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Transactions transactions = new Transactions();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Choose an option:");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Check Balance");
            System.out.println("4: Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int depositAccountNo = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = sc.nextDouble();
                    transactions.deposit(depositAccountNo, depositAmount);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int withdrawAccountNo = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    transactions.withdraw(withdrawAccountNo, withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    int checkBalanceAccountNo = sc.nextInt();
                    transactions.checkBalance(checkBalanceAccountNo);
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    
    }
}
