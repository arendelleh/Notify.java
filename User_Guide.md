# Notify.java User Guide

## Purpose

Practice selecting notification channels and displaying campus reminders. Messages are simulated and are not delivered to anyone.

## Requirements and setup

Use a computer with a JDK and a terminal. Save `Main.java` in a folder. Open that folder in VS Code, then select Terminal > New Terminal. Check `java -version` and `javac -version`. Both must display a version.

## Run

Run `javac Main.java`. If no compilation error appears, run `java Main`.

## Basic usage

1. Type `1` for Email, `2` for SMS, or `3` for Push, then press Enter.
2. Type your message and press Enter.
3. Read the message displayed with the selected channel label.
4. Repeat with another channel, or enter `0` at the menu to exit.

Example: choose `2`, then enter `Bring your ID.` The output is `[SMS] Bring your ID.`

## Troubleshooting

| Problem | Action |
| :--- | :--- |
| java or javac is not recognized | Check that a JDK is installed and its bin folder is on PATH. Restart the terminal after changing PATH. |
| Main.java is not found | Open the terminal in the folder containing the saved source file. |
| Main class cannot be found | Save the complete code and compile successfully in the same folder before running. |
| Invalid choice | Enter 0, 1, 2, or 3 at the menu. |
| Message must not be blank | Enter a message containing non-whitespace text. |

## Known limitations

No real delivery or saved message history. Exit with `0` at the menu, not at the message prompt.
