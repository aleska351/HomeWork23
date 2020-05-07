import java.math.BigInteger;

public class FibonacciThread extends Thread{
    public BigInteger n;
    BigInteger current = BigInteger.valueOf(1);
    BigInteger previous = BigInteger.valueOf(1);
    public void run() {
       while(!isInterrupted()){
           fibonacciNumber();
           try {
               Thread.sleep(150);
           } catch (InterruptedException e) {
               System.out.println("Sleep was interrupted");
               System.out.println("Previous number Fibonacci " + previous);
               System.out.println("Next number Fibonacci " + current);
               return;
           }
        }
    }

    private void fibonacciNumber() {
        n=previous.add(current);
        System.out.print(n+" ");
        previous=current;
        current=n;
    }
}


