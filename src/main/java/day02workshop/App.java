package day02workshop;

import java.util.Random;
import java.util.UUID;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to banking!");

        int n = 3;
        BankAccount bankAccount[] = new BankAccount[n];

        for (int i = 0; i < bankAccount.length; i++) {
            String uuid = UUID.randomUUID().toString();

            double max = 10000.00;
            double min = 10000.00;

            Random randomNum = new Random();
            double initialBalance = min + randomNum.nextDouble(max);

            bankAccount[i] = new FixedDepositAccount(uuid, initialBalance);

        }

        bankAccount[0].setName("John Smith");
        bankAccount[1].setName("Tom Hanks");
        bankAccount[2].setName("Sally Tan");
        bankAccount[0].showAccount();
        bankAccount[1].showAccount();
        bankAccount[2].showAccount();

        bankAccount[0].deposit(123.45);
        bankAccount[1].withdraw(4252.3);
        bankAccount[2].deposit(32432.4);

        bankAccount[0].showAccount();
        bankAccount[1].showAccount();
        bankAccount[2].showAccount();

    }
}
