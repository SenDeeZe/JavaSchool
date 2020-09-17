package terminal.repository;

import terminal.util.PinValidator;

public interface Terminal {
    public void bankAccountCheck(PinValidator pinValidator);
    public void withdrawMoney(PinValidator pinValidator, int amountOfMoney);
    public void depositMoney(PinValidator pinValidator, int amountOfMoney);
}
