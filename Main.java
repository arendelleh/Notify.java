import java.util.Scanner;

// Strategy: every notification channel follows this common contract.
interface NotificationStrategy {
    void send(String message);
}

// Concrete strategies simulate sending; no real SMS or email is sent.
class EmailNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("[Email] " + message);
    }
}

class SmsNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("[SMS] " + message);
    }
}

class PushNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("[Push] " + message);
    }
}

// Context: delegates sending to the selected strategy.
class NotificationService {
    private NotificationStrategy strategy;

    public NotificationService(NotificationStrategy strategy) {
        setStrategy(strategy);
    }

    /**
     * Replaces the current notification channel.
     * @param strategy the non-null channel implementation to use
     * @throws IllegalArgumentException if strategy is null
     */
    public void setStrategy(NotificationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Notification strategy is required.");
        }
        this.strategy = strategy;
    }

    /**
     * Validates a message and delegates it to the current channel.
     * The supplied channels print console output; no actual delivery occurs.
     * @param message the text to display; surrounding whitespace is preserved
     * @throws IllegalArgumentException if message is null or blank after trim
     */
    public void notifyUser(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message must not be blank.");
        }
        strategy.send(message);
    }
}

// Client: changes the strategy on the same context at runtime.
public class Main {
    public static void main(String[] args) {
        System.out.println("Notify.java - Strategy Pattern Demo");
        System.out.println("Simulation only: no actual messages are sent.");

        NotificationService service =
                new NotificationService(new EmailNotification());

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nChoose notification channel:");
                System.out.println("1. Email");
                System.out.println("2. SMS");
                System.out.println("3. Push");
                System.out.println("0. Exit");
                System.out.print("Choice: ");
                if (!input.hasNextLine()) {
                    break;
                }
                String choice = input.nextLine().trim();

                switch (choice) {
                    case "1":
                        service.setStrategy(new EmailNotification());
                        break;
                    case "2":
                        service.setStrategy(new SmsNotification());
                        break;
                    case "3":
                        service.setStrategy(new PushNotification());
                        break;
                    case "0":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Enter 0, 1, 2, or 3.");
                        continue;
                }

                while (true) {
                    System.out.print("Enter message: ");
                    if (!input.hasNextLine()) {
                        return;
                    }
                    String message = input.nextLine();
                    try {
                        service.notifyUser(message);
                        break;
                    } catch (IllegalArgumentException error) {
                        System.out.println("Validation: " + error.getMessage());
                    }
                }
            }
        }
    }
}


