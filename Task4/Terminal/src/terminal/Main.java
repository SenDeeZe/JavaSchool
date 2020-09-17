package terminal;

import terminal.exception.AccountIsLockedException;
import terminal.repository.Terminal;
import terminal.repository.TerminalImpl;
import terminal.util.PinValidator;

public class Main {
    public static void main(String[] args) {
        PinValidator pv = new PinValidator();
        try {
            pv.validate();
            Terminal term = new TerminalImpl();
            term.bankAccountCheck(pv);
            term.depositMoney(pv, 100);
            term.withdrawMoney(pv, 100);
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
        }
    }
}
