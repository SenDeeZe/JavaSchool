package terminal.exception;

public class DepositException extends Exception {
    public DepositException() {
        super("Incorrect amount of money");
    }
}
