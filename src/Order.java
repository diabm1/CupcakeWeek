import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Cupcake> cupcakeMenu;
    private ArrayList<Drink> drinkMenu;
    private Scanner input;

    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        this.cupcakeMenu = cupcakeMenu;
        this.drinkMenu = drinkMenu;
        this.input = new Scanner(System.in);
    }

    public void createReceipt() {
        ArrayList<Object> order = new ArrayList<>();
        boolean ordering = true;
        double subtotal = 0.0;

        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        String placeOrder = input.nextLine();

        if (!placeOrder.equalsIgnoreCase("Y")) {
            System.out.println("Have a nice day then.");
            return;
        }

        System.out.println("Here is the menu.");
        System.out.println("CUPCAKES:");
        int itemNumber = 1;

        for (Cupcake cupcake : cupcakeMenu) {
            System.out.println(itemNumber++);
            cupcake.type();
            System.out.println(cupcake.getPrice());
            System.out.println();
        }

        System.out.println("DRINKS:");
        for (Drink drink : drinkMenu) {
            System.out.println(itemNumber++);
            drink.type();
            System.out.println(drink.getPrice());
            System.out.println();
        }

        while (ordering) {
            System.out.println("What would you like to order? Please use the number associated with each item to order.");
            int orderChoice = input.nextInt();
            input.nextLine();

            if (orderChoice >= 1 && orderChoice <= itemNumber) {
                if (orderChoice <= cupcakeMenu.size()) {
                    Cupcake selectedCupcake = cupcakeMenu.get(orderChoice - 1);
                    order.add(selectedCupcake);
                    subtotal += selectedCupcake.getPrice();
                } else {
                    Drink selectedDrink = drinkMenu.get(orderChoice - cupcakeMenu.size() - 1);
                    order.add(selectedDrink);
                    subtotal += selectedDrink.getPrice();
                }
                System.out.println("Item added to order");
            } else {
                System.out.println("Sorry, we don't seem to have that on the menu.");
            }

            System.out.println("Would you like to continue ordering? (Y/N)");
            placeOrder = input.nextLine();

            if (!placeOrder.equalsIgnoreCase("Y")) {
                ordering = false;
            }
        }

        System.out.println("Receipt:");
        System.out.println("---------");

        for (Object item : order) {
            System.out.println(item);
        }

        System.out.println("---------");
        System.out.printf("$%.2f%n", subtotal);

        CreateFile createFile = new CreateFile();
        WriteToFile writeToFile = new WriteToFile(order);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println(date);
        System.out.println(time);
    }



    public class CreateFile {
        public CreateFile() {
            try {
                File salesData = new File("salesData.txt");

                if (salesData.createNewFile()) {
                    System.out.println("File created: " + salesData.getName());
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.out.println("An error occurred");
            }
        }
    }

    public class WriteToFile {
        public WriteToFile(ArrayList<Object> order) {
            try {
                FileWriter fw = new FileWriter("salesData.txt", true);
                PrintWriter salesWriter = new PrintWriter(fw);

                for (Object item : order) {
                    salesWriter.println(item);
                }

                salesWriter.close();
                System.out.println("Successfully wrote to the file");
            } catch (IOException e) {
                System.out.println("An error occurred");
            }
        }
    }
}
