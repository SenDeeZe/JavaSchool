package terminal.exception;

public class AccountIsLockedException extends RuntimeException {

    public AccountIsLockedException(long a) {
        super("Wrong pin\n Next try will be available in: " + a + " seconds");
    }
}
