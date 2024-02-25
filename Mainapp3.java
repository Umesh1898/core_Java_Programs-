import java.util.Scanner;

// Bank interface
interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

// AxisBank class implementing Bank interface
class AxisBank implements Bank {

    double accountBalance;

    public AxisBank(double accountBalance) {
        if (accountBalance >= 5000) {
            this.accountBalance = accountBalance;
            System.out.println("Account opened successfully");
        } else {
            System.out.println("Required minimum amount must be 5000Rs");
        }
    }

    public void deposit(double amount) {
        accountBalance += amount;
        double charges = amount * 0.02;
        accountBalance -= charges;
        System.out.println(amount + " Rs Credited to your account");
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            double charges = amount * 0.02;
            accountBalance -= charges;
            System.out.println(amount + " Rs Debited to your account");
        } else {
            System.out.println("Insufficient amount to withdraw");
        }
    }

    public void checkBalance() {
        System.out.println("Active Balance is: " + accountBalance);
    }
}

// ICICIBank class implementing Bank interface
class ICICIBank implements Bank {

    double accountBalance;

    public ICICIBank(double accountBalance) {
        if (accountBalance >= 10000) {
            this.accountBalance = accountBalance;
            System.out.println("Account opened successfully");
        } else {
            System.out.println("Required minimum amount must be 10000Rs");
        }
    }

    public void deposit(double amount) {
        accountBalance += amount;
        double charges = amount * 0.03;
        accountBalance -= charges;
        System.out.println(amount + " Rs Credited to your account");
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            double charges = amount * 0.03;
            accountBalance -= charges;
            System.out.println(amount + " Rs Debited to your account");
        } else {
            System.out.println("Insufficient amount to withdraw");
        }
    }

    public void checkBalance() {
        System.out.println("Active Balance is: " + accountBalance);
    }
}

// BankFactory class
class BankFactory {
    Bank bank = null;

    // Modified the return type of the method to Bank
    Bank openAccount(int choice, double amount) {
        if (choice == 1) {
            bank = new AxisBank(amount);
        } else if (choice == 2) {
            bank = new ICICIBank(amount);
        }
        return bank; // Return the created bank instance
    }
}

// Mainapp3 class
public class Mainapp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Bank");
        System.out.println("1:Axis\n2:ICICI");
        int choice = sc.nextInt();
        System.out.println("Enter Initial amount");
        double amount = sc.nextDouble();
        BankFactory b1 = new BankFactory();
        
        // Retrieve the bank instance returned by openAccount
        Bank bank = b1.openAccount(choice, amount);

        boolean status = true;
        while (status) {
            System.out.println("Select mode of transaction");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Check balance");
            System.out.println("4: Exit");

            int mode = sc.nextInt();
            switch (mode) {
                case 1:
                    System.out.println("Enter Amount");
                    double depositAmount = sc.nextDouble();
                    bank.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter Amount");
                    double withdrawAmount = sc.nextDouble();
                    bank.withdraw(withdrawAmount);
                    break;

                case 3:
                    bank.checkBalance();
                    break;

                default:
                    status = false;
                    break;
            }
        }
    }
}
