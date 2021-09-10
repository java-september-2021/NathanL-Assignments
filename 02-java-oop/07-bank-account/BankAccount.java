public class BankAccount {
    private static int numAccounts = 0;
    private static double accountsTotalValue = 0;
    protected double checkingBalance = 0;
    protected double savingBalance = 0;

    public BankAccount(double checkingBalance, double savingBalance) {
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
        numAccounts += 1;
    }

    public BankAccount() {
        numAccounts += 1;
    }

    public void getsavingBalance() {
        System.out.println("Current saving balance: " + this.savingBalance);
    }

    public void getCheckingBalance() {
        System.out.println("Current checking balance: " + this.checkingBalance);
    }

    public void deposit(String account, int amount) {
        if (account == "saving") {
            this.savingBalance += amount;
            accountsTotalValue += amount;
            System.out.println("Current saving balance: " + this.savingBalance);
        } else if (account == "checking") {
            this.checkingBalance += amount;
            accountsTotalValue += amount;
            System.out.println("Current checking balance: " + this.checkingBalance);
        } else {
            System.out.println("Please enter saving or checking");
        }
    }

    public void withdraw(String account, int amount) {
        if (account == "saving") {
            if (this.savingBalance > amount){
                this.savingBalance -= amount;
                accountsTotalValue -= amount;
                System.out.println("Current saving balance: " + this.savingBalance);
            } else {
                System.out.println("Insufficient funds!");
            }
        } else if (account == "checking") {
            if (this.savingBalance > amount){
            this.checkingBalance -= amount;
            accountsTotalValue -= amount;
            System.out.println("Current checking balance: " + this.checkingBalance);
        } else {
            System.out.println("Insufficient funds!");
        }
        } else {
            System.out.println("Please enter saving or checking");
        }
    }

    public static void displayFunds(){
        System.out.println("The total value of all accounts is: " + accountsTotalValue);
    }

    public static void displayAccounts(){
        System.out.println("The total number of accounts is: " + numAccounts);
    }
}
