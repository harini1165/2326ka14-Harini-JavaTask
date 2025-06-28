package Day6;

class MessageTask implements Runnable {
    String message;

    MessageTask(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        Runnable task1 = new MessageTask("Hello from Thread 1");
        Runnable task2 = new MessageTask("Hello from Thread 2");

        Thread thread1 = new Thread(task1, "Thread-A");
        Thread thread2 = new Thread(task2, "Thread-B");

        thread1.start();
        thread2.start();
    }
}
