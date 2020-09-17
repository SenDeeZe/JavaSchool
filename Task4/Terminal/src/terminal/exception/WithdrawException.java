package terminal.exception;

public class WithdrawException extends Exception {
    public WithdrawException(int money, boolean i) {
        super(i ? "Not enough money to withdraw " + i : "Incorrect amount of money");

    }
}
