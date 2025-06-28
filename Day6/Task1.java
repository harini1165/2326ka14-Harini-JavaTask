package Day6;

class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        t1.start(); // Start the thread
    }
}

