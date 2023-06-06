import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Drink> drinkMenu = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // Water
        System.out.println("We are deciding on the price for water.");
        Drink water = new Drink();
        water.type();
        System.out.println("How much would you like to charge for water? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        water.setPrice(price);
        drinkMenu.add(water);

        // Soda
        System.out.println("We are deciding on the price for soda.");
        Soda soda = new Soda();
        soda.type();
        System.out.println("How much would you like to charge for soda? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);
        drinkMenu.add(soda);

        // Milk
        System.out.println("We are deciding on the price for milk.");
        Milk milk = new Milk();
        milk.type();
        System.out.println("How much would you like to charge for milk? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);
        drinkMenu.add(milk);

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        // Standard Cupcake
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        Cupcake cupcake = new Cupcake();
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        cupcakeMenu.add(cupcake);


        // Red Velvet Cupcake
        System.out.println("We are deciding on the price for our Red Velvet cupcake. Here is the description:");
        RedVelvet redVelvet = new RedVelvet();
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);
        cupcakeMenu.add(redVelvet);


        // Chocolate Cupcake
        System.out.println("We are deciding on the price for our Chocolate cupcake. Here is the description:");
        Chocolate chocolate = new Chocolate();
        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);
        cupcakeMenu.add(chocolate);
    }

    static class Cupcake {
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price){
            this.price = price;
        }

        public void type(){
            System.out.println("A basic, generic cupcake, with vanilla frosting");
        }
    }

    static class RedVelvet extends Cupcake {
        @Override
        public void type() {
            System.out.println("A red velvet based cupcake, with cream cheese frosting.");
        }
    }

    static class Chocolate extends Cupcake {
        @Override
        public void type() {
            System.out.println("A chocolate based cupcake, with chocolate frosting.");
        }
    }

    static class Drink {
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void type() {
            System.out.println("A generic drink.");
        }
    }

    static class Soda extends Drink {
        @Override
        public void type() {
            System.out.println("A bottle of soda.");
        }
    }

    static class Milk extends Drink {
        @Override
        public void type() {
            System.out.println("A bottle of milk.");
        }
    }
}
