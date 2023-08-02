import java.text.SimpleDateFormat;

class DateDisplayer1
{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ss HH:mm:ss");
    public void print() {
        for(int i=0; i<7; i++)
        {
            System.out.println(i+1+":"+format.format(System.currentTimeMillis()));
            try
            {
              Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
            }
        }
    }
}
class DateDisaplayer2 extends Thread
{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:ss HH:mm:ss");
    public void run()
    {
        for(int i=0; i<7;i++)
        {
            System.out.println(Thread.currentThread().getName()+"("+(i+1)+")"+ format.format(System.currentTimeMillis()));
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {

            }
        }
    }
}



public class Tester {
    public static void main (String args[])
    {
        DateDisplayer1 ddp1 = new DateDisplayer1();
        long beforeTime1 = System.currentTimeMillis();
        for(int i=0; i<3; i++)
        {
            ddp1.print();
        }
    long secDiffTime1 = (System.currentTimeMillis()-beforeTime1)/1000;
        System.out.println("클래스 1시간"+secDiffTime1);



        DateDisaplayer2 thread1 = new DateDisaplayer2();
        DateDisaplayer2 thread2 = new DateDisaplayer2();
        DateDisaplayer2 thread3 = new DateDisaplayer2();

        long beforeTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();

        while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive());

        long secDiffTime2 = (System.currentTimeMillis()-beforeTime1)/1000;
        System.out.println("클래스2:"+secDiffTime2);









    }
}
