package terminal.model;

import terminal.exception.DepositException;
import terminal.exception.WithdrawException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TerminalServer {

    private Map<String, Integer> pinsList = new HashMap<>();
    private static String fileName = "ClientDataProvider.txt";

    public TerminalServer() {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty!");
        } else {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String anyString;
                while ((anyString = br.readLine()) != null) {
                    String[] words = anyString.split(" ");
                    pinsList.put(words[0], Integer.parseInt(words[1]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, Integer> getPinsList() {
        return pinsList;
    }

    public void setPinsList(Map<String, Integer> pinsList) {
        this.pinsList = pinsList;
    }

    public void withdrawMoneyOnServer(String pin, int amountOfMoney) throws WithdrawException {
        if (amountOfMoney % 100 == 0) {
            Map<String, Integer> clientsList = getPinsList();
            int newBalance = clientsList.get(pin) - amountOfMoney;
            if (newBalance < 0)
                throw new WithdrawException(amountOfMoney, true);
            clientsList.put(pin, newBalance);
            setPinsList(clientsList);
            System.out.println("Funds were successfully withdrawn from the account");
        } else
            throw new WithdrawException(amountOfMoney, false);
    }

    public void depositMoneyOnServer(String pin, int amountOfMoney) throws DepositException {
        if (amountOfMoney % 100 == 0) {
            Map<String, Integer> clientsList = getPinsList();
            int newBalance = clientsList.get(pin) + amountOfMoney;
            clientsList.put(pin, newBalance);
            setPinsList(clientsList);
            System.out.println("Funds were successfully deposit on the account");
        } else
            throw new DepositException();
    }
}
