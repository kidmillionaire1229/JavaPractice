class BankAccount
{
    private int accountNumber;
    private double balance;
    BankAccount(int accountNumber)
    {
        this.accountNumber = accountNumber;
        balance = 0;
    }
    public int getAccountNumber ()
    {
        return accountNumber;
    }
    public void printAccountInfo()
    {
        System.out.println("accountNumber: "+accountNumber);
        System.out.println("balance: "+balance);
    }
    public boolean deposit(double amount)
    {
        try
        {
            if(amount<=0)
            {
                throw new DepositException(amount);
            }
            else
            {
                balance += amount;
            }
        }
        catch(DepositException e)
        {
            System.out.println("you cannot deposit amount of: "+e.getAmount());
            return false;
        }
        return true;
    }
    public boolean withdraw (double amount)
    {
        try
        {
            if(amount>balance)
            {
                throw new WithdrawException(amount, balance);
            }
            else
            {
                balance -= amount;
            }
        }
        catch(WithdrawException e)
        {
            System.out.println(e.getCurrentBalance()+"에서"+e.getAmount()+"출금 불가");
            return false;
        }
        return true;
    }

}
class DepositException extends Exception
{
    private double amount;
    DepositException(double amount)
    {
        this.amount = amount ;
    }
    public double getAmount()
    {
        return amount;
    }
}
class WithdrawException extends Exception
{
    private double amount;
    private double currentBalance;

    public double getAmount() {
        return amount;
    }
    public double getCurrentBalance()
    {
            return currentBalance;
    }
    WithdrawException(double amount, double balance)
    {
        this.amount = amount;
        currentBalance = balance;
    }

}


public class Tester
{
    public static void main(String args[])
    {
        BankAccount b1 = new BankAccount('1');
        System.out.println("500입금 후");
        b1.deposit(500);
        b1.printAccountInfo();

        System.out.println("0입금 후");
        b1.deposit(0);
        b1.printAccountInfo();

        System.out.println("100 출금");
        b1.withdraw(100);
        b1.printAccountInfo();

        System.out.println("500출금");
        b1.withdraw(500);
        b1.printAccountInfo();
    }
}
