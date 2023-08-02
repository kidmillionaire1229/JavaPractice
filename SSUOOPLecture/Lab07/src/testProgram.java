import java.util.ArrayList;

class BankAccount
{
    private int accountNumber;
    protected double balance;
    BankAccount(int accountNumber)
    {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }
    public boolean deposit(double amount)
    {
        if(amount<=0)
        {
            System.out.println("0이하 불가");
            return false;
        }
        else
        {
            balance += amount;
        }
        return true;
    }
    public boolean withdraw(double amount)
    {
        if(balance < amount)
        {
            System.out.println("잔액초가 출금");
            return false;
        }
        else
        {
            balance -= amount;
        }
    return true;
    }
    public int getAccountNumber()
    {
        return accountNumber;
    }
    public void printAccountInfo()
    {
        System.out.println("balance:"+balance);
        System.out.println("accountNumber: "+accountNumber);
    }
}

class SavingsAccount extends BankAccount
{
    static double interestRate = 0.02;
    SavingsAccount(int accountNumber)
    {
        super(accountNumber);
    }
    double computeInterest()
        {
            return balance * interestRate;
        }
    @Override
    public void printAccountInfo()
    {
        super.printAccountInfo();
        System.out.println("이자율"+interestRate);
    }
}
class Customer
{
    private int IDnumber;
    private ArrayList<BankAccount> myAccounts= new ArrayList<>();
    String name;
    Customer(int IDnumber, String name)
    {
        this.IDnumber = IDnumber;
        this.name = name;
    }
    public boolean addAccount(BankAccount b)
    {
        if(myAccounts.contains(b))
        {
            System.out.println("이미 있음");
            return false;
        }
        else
        {
            myAccounts.add(b);
        }
        return true;
    }
    public boolean deleteAccount(BankAccount b)
    {
        if(myAccounts.contains(b))
        {
            myAccounts.remove(b);
            return true;
        }
        else
    {
        System.out.println("없음");
    }
    return false;
    }
    public void printCustomer()
    {
        System.out.println("ID"+IDnumber);
        System.out.println("name"+name);

        for(BankAccount b: myAccounts)
        {
            b.printAccountInfo();
        }
    }
}






public class testProgram
{
    public static void main(String args[])
    {
        Customer c1 = new Customer(1,"john");
        c1.printCustomer();

        System.out.println("500입금 후");
        BankAccount b1 = new BankAccount(111);
        b1.deposit(500);
        b1.printAccountInfo();

        System.out.println("1000입금 후");
        SavingsAccount s1 = new SavingsAccount(2);
        s1.deposit(1000);
        s1.printAccountInfo();

        s1.withdraw(100);
        s1.printAccountInfo();
        s1.deposit(s1.computeInterest());
        s1.printAccountInfo();

        c1.addAccount(b1);
        c1.addAccount(s1);
        c1.printCustomer();
        c1.deleteAccount(s1);
        c1.printCustomer();
    }
}
