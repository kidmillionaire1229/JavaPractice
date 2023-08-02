
class BankAccount
{
    private int AccountNumber;
    protected double Balance;
    BankAccount(int number)
    {
        Balance = 0;
        AccountNumber = number;
    }
   boolean deposit(double amount)
   {
       if(amount<=0)
       {
           System.out.println("0보다 큰 값을 입급하세요.");
           return false;
       }
       else
       {
           Balance += amount;
           return true;
       }
   }
    String get_Account_Info(){
        return "account number: "+AccountNumber + ", Balance: "+Balance;
    }

    boolean withdraw(double amount)
    {
        if(amount> Balance)
        {
            System.out.println("잔액보다 더 큰 값을 입력하였습니다.");
            return false;
        }
        else
        {
            System.out.println("출금 성공");
            Balance -= amount;
            return true;
        }
    }
}

class Savings_Account extends BankAccount {
    static double interest_Rate = 0.02;

    Savings_Account(int number) {
        super(number);
    }

    double computeInterest() {
        return interest_Rate * Balance;
    }


}

public class testProgram
{
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1);
        System.out.println("[100 입금 후]");
        b1.deposit(100.0);
        System.out.println(b1.get_Account_Info());
        System.out.println("");

        Savings_Account s1 = new Savings_Account(2);
        System.out.println("[200 입금 후]");
        s1.deposit(200.0);
        System.out.println(s1.get_Account_Info());

        System.out.println("");
        System.out.println("[50 출금 후]");
        s1.withdraw(50.0);
        System.out.println(s1.get_Account_Info());

        System.out.println("");
        System.out.println("[이자 계산]");
        System.out.println(s1.computeInterest());

        System.out.println("");
        System.out.println("[이자 계산 후]");
        s1.deposit(s1.computeInterest());
        System.out.println(s1.get_Account_Info());
    }





}
