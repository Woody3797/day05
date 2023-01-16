package day03workshop;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        
        String dirPath = "./cartdata";
        // instantiates a file/dir object
        File newDirectory = new File(dirPath);
        String fileName = "";

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
                    listCart(cartItems);
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

            if (input.startsWith("login")) {
                createLoginFile(input, dirPath, fileName);
            }

            String strValue = "";
            if (input.startsWith("add")) {
                input = input.replace(",", " ");
                Scanner scanner = new Scanner(input.substring(4));

                while (scanner.hasNext()) {
                    strValue = scanner.next();
                    cartItems.add(strValue);
                }
            }

            if (input.startsWith("delete")) {
                cartItems = deleteCartItem(cartItems, input);
            }
        }
    }

    public static void listCart(List<String> cartItems) {
        if (cartItems.size() > 0) {
            int count = 1;
            for (String item : cartItems) {
                System.out.println(count + ". " + item);
                count++;
            }
        } else {
            System.out.println("Your cart is empty!");
        }
    }

    public static List<String> deleteCartItem(List<String> cartItems, String input) {
        String strValue = "";
        Scanner scanner = new Scanner(input.substring(6));

        while (scanner.hasNext()) {
            strValue = scanner.next();
            int listItemIndex = Integer.parseInt(strValue);

            if (listItemIndex < cartItems.size()) {
                cartItems.remove(listItemIndex - 1);
            } else {
                System.out.println("Incorrect item index");
            }
        }
        return cartItems;
    }

    public static void createLoginFile(String input, String dirPath, String fileName) throws IOException {
        input = input.replace(",", " ");

        Scanner scanner = new Scanner(input.substring(6));

        while (scanner.hasNext()) {
            fileName = scanner.next();
        }
        //define filepath and filename
        File loginFile = new File(dirPath + File.separator + fileName + ".txt");
        boolean isCreated = loginFile.createNewFile();

        if (isCreated) {
            System.out.println("New file created " + loginFile.getCanonicalPath());
        } else {
            System.out.println("File already created");
        }
    }
}
