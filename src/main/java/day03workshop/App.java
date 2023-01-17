package day03workshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
                case "users":
                    listUsers(dirPath);
                    break;
                case "list":
                    cartItems = readCartItemsFromFile(dirPath, fileName);
                    listCart(cartItems);
                    break;
                default:
                    System.out.println("> list to show a list of items in your shopping cart\n> login <name> to access your shopping cart\n> add <item> to add items into your shopping cart\n> delete <item #> to delete item from shopping cart\n> quit to exit this program");
                    break;
            }

            if (input.startsWith("login")) {
                fileName = createLoginFile(input, dirPath, fileName);
            }

            String strValue = "";
            if (input.startsWith("add")) {
                input = input.replace(",", " ");
                Scanner scanner = new Scanner(input.substring(4));

                FileWriter fw = new FileWriter(dirPath + File.separator + fileName, true);
                PrintWriter pw = new PrintWriter(fw);

                while (scanner.hasNext()) {
                    strValue = scanner.next();
                    cartItems.add(strValue);
                    pw.printf("%s\n", strValue);
                }

                pw.flush();
                fw.flush();
                pw.close();
                fw.close();
            }

            if (input.startsWith("delete")) {
                cartItems = deleteCartItem(cartItems, input);
                updateCartItemToFile(cartItems, dirPath, fileName);
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

    public static void updateCartItemToFile(List<String> cartItems, String dirPath, String fileName) throws IOException {
        FileWriter fw = new FileWriter(dirPath + File.separator + fileName, false);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String item : cartItems) {
            bw.write(item);
            bw.newLine();
        }
        bw.flush();
        fw.flush();
        bw.close();
        fw.close();
    }

    public static List<String> deleteCartItem(List<String> cartItems, String input) {
        String strValue = "";
        Scanner scanner = new Scanner(input.substring(6));

        while (scanner.hasNext()) {
            strValue = scanner.next();
            int listItemIndex = Integer.parseInt(strValue);

            if (listItemIndex <= cartItems.size()) {
                cartItems.remove(listItemIndex - 1);
            } else {
                System.out.println("Incorrect item index");
            }
        }
        return cartItems;
    }

    public static String createLoginFile(String input, String dirPath, String fileName) throws IOException {
        input = input.replace(",", " ");
        Scanner scanner = new Scanner(input.substring(6));

        while (scanner.hasNext()) {
            fileName = scanner.next();
        }
        //define filepath and filename
        File loginFile = new File(dirPath + File.separator + fileName);
        boolean isCreated = loginFile.createNewFile();

        if (isCreated) {
            System.out.println("New file created " + loginFile.getCanonicalPath());
        } else {
            System.out.println("File already created");
        }

        return fileName;
    }

    public static void listUsers(String dirPath) {
        File directoryPath = new File(dirPath);

        String[] contents = directoryPath.list();
        for (String file : contents) {
            System.out.println(file);
        }
    }

    public static List<String> readCartItemsFromFile(String dirPath, String fileName) throws IOException {
        File file = new File(dirPath + File.separator + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        List<String> items = new ArrayList<>();

        while ((str = br.readLine()) != null) {
            items.add(str);
        }
        br.close();
        return items;
    }
}
