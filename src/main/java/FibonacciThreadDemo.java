public class FibonacciThreadDemo {
    public static void main(String[] args) {
        FibonacciThread thread = new FibonacciThread();
        thread.start();
        try {
            thread.join(3000);// прерываем через 3 секунды
            System.out.println();
            System.out.println("Fibonacci: " + thread.current);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        thread.interrupt();
    }
}
