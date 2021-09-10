public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount act1 = new BankAccount();
        act1.deposit("saving", 100);
        act1.deposit("checking", 200);
        act1.getCheckingBalance();
        act1.getsavingBalance();

        BankAccount act2 = new BankAccount();
        act2.deposit("saving", 300);
        act2.deposit("checking", 400);
        act2.withdraw("saving", 200);
        act2.withdraw("checking", 500);
        act2.getCheckingBalance();
        act2.getsavingBalance();

        BankAccount.displayFunds();
        BankAccount.displayAccounts();
    }
}
