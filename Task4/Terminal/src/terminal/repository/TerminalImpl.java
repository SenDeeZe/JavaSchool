package terminal.repository;

import terminal.exception.DepositException;
import terminal.exception.WithdrawException;
import terminal.model.TerminalServer;
import terminal.util.PinValidator;

import java.util.Map;

public class TerminalImpl implements Terminal {

    private TerminalServer server = new TerminalServer();

    @Override
    public void bankAccountCheck(PinValidator pinValidator) {
        if (pinValidator.isAuthorized()){
            Map<String, Integer> clientList = server.getPinsList();
            System.out.println(clientList.get(pinValidator.getUserPin()) + " Rub");
        }
    }

    @Override
    public void withdrawMoney(PinValidator pinValidator, int amountOfMoney) {
        if (pinValidator.isAuthorized()) {
            try {
                server.withdrawMoneyOnServer(pinValidator.getUserPin(), amountOfMoney);
            } catch (WithdrawException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void depositMoney(PinValidator pinValidator, int amountOfMoney) {
        if (pinValidator.isAuthorized()) {
            try {
                server.depositMoneyOnServer(pinValidator.getUserPin(), amountOfMoney);
            } catch (DepositException e) {
                e.printStackTrace();
            }
        }
    }
}
