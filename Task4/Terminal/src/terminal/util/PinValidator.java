package terminal.util;

import terminal.exception.AccountIsLockedException;
import terminal.model.TerminalServer;

import java.time.Instant;
import java.util.Scanner;

public class PinValidator {

    private TerminalServer server = new TerminalServer();
    private static final int MAX_ATTEMPTS_COUNT = 3;
    private static final int BLOCK_TIME_SEC = 10;

    private boolean isBlocked;
    private int currentAttempts;
    private String userPin;
    private boolean isAuthorized;
    private Instant lockTime;

    public PinValidator() {
        isBlocked = false;
        currentAttempts = 0;
        userPin = "";
        isAuthorized = false;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public String getUserPin() {
        return userPin;
    }

    private void unblock(){
        isBlocked = false;
    }

    private boolean isPinCorrect(String pin){
        for (String s : server.getPinsList().keySet()) {
            if (s.equals(userPin))
                return s.equals(userPin);
        }
        return false;
    }

    private boolean checkIfBlocked() throws AccountIsLockedException {
        if (isBlocked){
            long timePassed = Instant.now().getEpochSecond() - lockTime.getEpochSecond();
                if (timePassed < BLOCK_TIME_SEC)
                    throw new AccountIsLockedException(BLOCK_TIME_SEC - timePassed);
                if (timePassed >BLOCK_TIME_SEC) {
                    isBlocked = false;
                    return false;
                }
                return true;
        }
        return false;
    }

    private void isTimeToBlock(){
        currentAttempts++;
        if (currentAttempts == MAX_ATTEMPTS_COUNT){
            isBlocked = true;
            lockTime = Instant.now();
            currentAttempts = 0;
        }
    }

    private void insertPin(){
        System.out.println("Insert pin:");
        Scanner sc = new Scanner(System.in);
        sc.hasNextInt();
        try {
            if (isBlocked == true) {
                checkIfBlocked();
            } else {
                int counter = 4;
                for (int i = 0; i < counter; i++) {
                    if (sc.hasNextInt()) {
                        userPin += sc.nextInt();
                    } else {
                        counter++;
                        System.out.println("Incorrect number");
                        sc.next();
                    }
                }
                System.out.println(userPin);
            }
        }
        catch (AccountIsLockedException e){
            e.getMessage();
        }
    }

    public void validate() throws AccountIsLockedException {

        insertPin();
        if (isPinCorrect(userPin)){
            isAuthorized = true;
            currentAttempts = 0;
        }
        else{
            if (isBlocked == false) {
                System.out.println("Incorrect pin. " + (2 - currentAttempts) + " tries left");
                userPin = "";
                isTimeToBlock();
            }
            validate();
        }
    }

}
