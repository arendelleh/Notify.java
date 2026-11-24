# Notify.java - Strategy Pattern Demo

## Description

A console-based Java application that demonstrates the Strategy design pattern by simulating notification delivery across multiple channels (EmailNotification, SmsNotification, and PushNotification). A NotificationService context delegates message output to the currently selected NotificationStrategy implementation, allowing the user to switch notification channels at runtime through a standard-input menu.

## Features

- **Runtime Strategy Switching:** Changes the active NotificationStrategy on a single NotificationService instance using `setStrategy(NotificationStrategy)`.
- **Simulated Notification Channels:**
  - EmailNotification: Prints `[Email] ` followed by the message.
  - SmsNotification: Prints `[SMS] ` followed by the message.
  - PushNotification: Prints `[Push] ` followed by the message.
- **Interactive Console Menu:** Uses java.util.Scanner (managed with try-with-resources) to prompt for a channel (1, 2, 3, or 0 to exit) and exits cleanly if standard input reaches EOF (`!input.hasNextLine()`).
- **Validation & Whitespace Preservation:**
  - Rejects a null strategy in NotificationService with `IllegalArgumentException("Notification strategy is required.")`.
  - Rejects null or blank messages (`message.trim().isEmpty()`) in `notifyUser(String)` with `IllegalArgumentException("Message must not be blank.")` and re-prompts until a non-blank line is entered.
  - Preserves surrounding whitespace on valid messages when passing them to `strategy.send(message)`.

## Technologies

- **Language:** Java
- **Standard Library:** java.util.Scanner and java.lang (System, String, IllegalArgumentException)
- **External Dependencies:** None

## Setup

Ensure a Java Development Kit (JDK) with javac and java is installed and available in your terminal.

Save the source code to a file named Main.java (required because the public class is named Main).

## Compile and Run Commands

From the directory containing Main.java:

```powershell
javac Main.java
java Main
```

## Usage Example

```text
Notify.java - Strategy Pattern Demo
Simulation only: no actual messages are sent.

Choose notification channel:
1. Email
2. SMS
3. Push
0. Exit
Choice: 1
Enter message: System update scheduled for 10:00 PM.
[Email] System update scheduled for 10:00 PM.

Choose notification channel:
1. Email
2. SMS
3. Push
0. Exit
Choice: 2
Enter message:    
Validation: Message must not be blank.
Enter message: Verification code: 482910
[SMS] Verification code: 482910

Choose notification channel:
1. Email
2. SMS
3. Push
0. Exit
Choice: 3
Enter message: New message received.
[Push] New message received.

Choose notification channel:
1. Email
2. SMS
3. Push
0. Exit
Choice: 0
Goodbye!
```

## Inputs and Outputs

### Inputs (System.in via Scanner)

| Prompt | Read Method | Valid Values | Behavior on Invalid / Special Input |
| :--- | :--- | :--- | :--- |
| Choice: | `input.nextLine().trim()` | "1" (Email), "2" (SMS), "3" (Push), "0" (Exit) | Prints `Invalid choice. Enter 0, 1, 2, or 3.` and repeats the menu; exits loop on EOF (`!input.hasNextLine()`). |
| Enter message: | `input.nextLine()` | Any non-null string where `!message.trim().isEmpty()` | Prints `Validation: Message must not be blank.` and re-prompts; exits program on EOF (`!input.hasNextLine()`). Surrounding whitespace on valid messages is preserved. |

Command-line arguments `String[] args` are accepted by main but are not read or used.

### Outputs (System.out)

**Startup Header:**

```text
Notify.java - Strategy Pattern Demo
Simulation only: no actual messages are sent.
```

**Menu and Prompts:**

```text
Choose notification channel:
1. Email
2. SMS
3. Push
0. Exit
Choice:
Enter message:
```

**Simulated Notification Lines:**

```text
[Email] <message>
[SMS] <message>
[Push] <message>
```

**Validation and Exit Messages:**

```text
Invalid choice. Enter 0, 1, 2, or 3.
Validation: Message must not be blank.
Goodbye!
```

## Project Structure

All types reside in a single source file (Main.java):

```text
Main.java
├── interface NotificationStrategy  # Common strategy interface defining void send(String message)
├── class EmailNotification         # Concrete strategy printing "[Email] " + message
├── class SmsNotification           # Concrete strategy printing "[SMS] " + message
├── class PushNotification          # Concrete strategy printing "[Push] " + message
├── class NotificationService       # Context holding NotificationStrategy; validates strategy and message
└── public class Main               # Console client managing Scanner input and runtime strategy switching
```

## Limitations

- **Simulation Only:** No actual emails, SMS messages, or push notifications are transmitted; all strategies only write to standard output (System.out).
- **Message-Only Payload:** `NotificationStrategy.send(String message)` accepts only a single String and does not include recipients, subjects, or delivery metadata.
- **Package-Private Access:** NotificationStrategy, EmailNotification, SmsNotification, PushNotification, and NotificationService have default (package-private) visibility, limiting reuse from outside the default package.
- **Filename vs. Banner Mismatch:** The startup output prints Notify.java - Strategy Pattern Demo, whereas the public class Main declaration requires the file to be named Main.java for standard compilation.

## Future Improvements

- **Real Channel Integrations:** Replace console System.out.println simulation in EmailNotification, SmsNotification, and PushNotification with actual delivery implementations.
- **Recipient and Metadata Support:** Extend the strategy contract to pass recipient details (such as email addresses, phone numbers, or device tokens) alongside the message content.
- **Modular File and Package Layout:** Separate NotificationStrategy, its concrete implementations, NotificationService, and Main into individual .java files with public visibility inside a named package.
- **Unit Testing:** Add automated tests covering NotificationService null-strategy rejection, blank-message validation, whitespace preservation, and strategy delegation.
