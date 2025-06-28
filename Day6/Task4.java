package Day6;

class TicketCounter {
    private int availableSeats = 5;

    public void bookTicket(String userName, int seatsToBook) {
        synchronized (this) {
            System.out.println(userName + " is trying to book " + seatsToBook + " seat(s).");

            if (seatsToBook <= availableSeats) {
                try {
                    // Simulate processing delay
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }

                availableSeats -= seatsToBook;
                System.out.println("" + userName + " successfully booked " + seatsToBook + " seat(s).");
            } else {
                System.out.println("Not enough seats for " + userName + ". Only " + availableSeats + " seat(s) left.");
            }

            System.out.println(" Remaining Seats: " + availableSeats + "\n");
        }
    }
}

class UserThread extends Thread {
    private TicketCounter counter;
    private String userName;
    private int seatsToBook;

    public UserThread(TicketCounter counter, String userName, int seatsToBook) {
        this.counter = counter;
        this.userName = userName;
        this.seatsToBook = seatsToBook;
    }

    public void run() {
        counter.bookTicket(userName, seatsToBook);
    }
}

public class Task4{
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // Simulating multiple users
        UserThread user1 = new UserThread(counter, "Alice", 2);
        UserThread user2 = new UserThread(counter, "Bob", 1);
        UserThread user3 = new UserThread(counter, "Charlie", 2);
        UserThread user4 = new UserThread(counter, "Diana", 2); // should fail if seats are already booked

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
