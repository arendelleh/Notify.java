# Notify.java

A Java console simulation of campus notifications using the Strategy Pattern. The project title is Notify.java; its source file is `Main.java`.

## Features

- Select Email, SMS, or Push output through a menu.
- Enter a message and display it using the selected channel.
- Reject unsupported menu choices and null or blank messages.
- Exit with option `0`.

## Technologies and requirements

Java and the standard-library `Scanner` class. Install a JDK providing both `java` and `javac` and make its `bin` folder available on PATH. No external libraries, database, or messaging account is required. The previous student run used Oracle JDK 25.0.5.1.

## Setup and run

Place `Main.java` in a folder and open a terminal in that folder. Check the environment:

```powershell
java -version
javac -version
```

Compile, then run only if compilation succeeds:

```powershell
javac Main.java
java Main
```

## Usage example

```text
Choice: 1
Enter message: Check your Canvas portal.
[Email] Check your Canvas portal.
```

Use `2` for SMS, `3` for Push, and `0` to exit. Invalid choices display `Invalid choice. Enter 0, 1, 2, or 3.` A blank message displays `Validation: Message must not be blank.` and prompts for a message again.

## Inputs and outputs

Menu input is read as text and trimmed before comparison. Messages are read as full lines and checked for blank content; accepted messages are printed without trimming. The program prints channel labels, validation messages, and `Goodbye!` on normal menu exit. It does not send real notifications.

## Project structure

| Component in Main.java | Role |
| :--- | :--- |
| NotificationStrategy | Common send interface |
| EmailNotification, SmsNotification, PushNotification | Console channel implementations |
| NotificationService | Holds the strategy, validates, and delegates |
| Main | Menu, input handling, and strategy selection |

Compilation generates `.class` files. Keep `Main.java` as the editable source.

## Limitations

No actual delivery, recipients, authentication, notification history, or file storage. Messages are not saved after exit. At the message prompt, `0` is message text; it exits only at the menu. End-of-input stops the application without necessarily printing `Goodbye!`.

## Possible future improvements

Add message history, recipient details, and automated tests. Real delivery would require external integrations and further error handling.
