package day03workshop;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    
    static String dirPath = "\\cartdata";
    String fileName = "";

    public static void main(String[] args) {
        
        File newDirectory = new File(dirPath);

        if(newDirectory.exists()) {
            System.out.println("Directory already exists");
        } else {
            newDirectory.mkdir();
        }

        System.out.println("Welcome to your shopping cart!");

        List<String> cartItems = new ArrayList<>();

        Console cons = System.console();
        String input = "";

        while (!input.equals("quit")) {
            input = cons.readLine("What do you want to perform? Type <quit> to exit program.\n");

            switch (input) {
                case "login":
                    
                    break;
                case "save":
                    break;
                case "users":
                    break;
                case "list":
                    if (cartItems.size() > 0) {
                        for (String item : cartItems) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Your cart is empty!");
                    }
                    break;
                default:
                    System.out.println("""
                            > list to show a list of items in your shopping cart
                            > login <name> to access your shopping cart
                            > add <item> to add items into your shopping cart
                            > delete <item #> to delete item from shopping cart
                            > quit to exit this program """);
                    break;
            }

            if (input.startsWith("add")) {
                input = input.replace(",", " ");
                String strValue = "";
                Scanner scanner = new Scanner(input.substring(4));

                while (scanner.hasNext()) {
                    strValue = scanner.next();
                    cartItems.add(strValue);
                }
            }
        }
    }
}
