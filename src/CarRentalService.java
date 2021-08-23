import java.util.Scanner;

public class CarRentalService {

    private static Scanner scanner = new Scanner(System.in);
    private static Car[] cars = {
            new Car("Prius", true, 1),
            new Car("Lambo", true, 2),
            new Car("Civic", true, 3),
            new Car("Jeep", true, 4)
    };

    public static void run() {
        while(true) {

            while(hasAvailableCar()) {
                displayAvailableCars();
                rentCar();
            }

            System.out.println("All cars have been rented, would you like to continue? (y/n)");

            while(true) {
                String input = scanner.nextLine();

                if(input.equalsIgnoreCase("n")) {
                    System.out.println("Goodbye!");
                    return;
                }
                else if(input.equalsIgnoreCase("y")) {
                    resetCars();
                    System.out.println("Cars have been restocked");
                    break;
                }
                else {
                    System.out.println("Invalid input. Try again.");
                }
            }
        }

    }

    private static void resetCars() {
        for(int i=0; i<cars.length; i++) {
            cars[i].setAvailable(true);
        }
    }

    private static void displayAvailableCars() {
        for(int i=0; i<cars.length; i++) {
            if(cars[i].isAvailable()) {
                System.out.println(i+1 + ") " + cars[i].getName());
            }
        }
    }

    private static void rentCar() {
        System.out.println("Enter a number to select the car you'd like to rent:");

        while(true) {
            try {
                String s = scanner.nextLine();
                int input = Integer.parseInt(s);

                if(cars[input-1].isAvailable()) {
                    cars[input-1].setAvailable(false);


                    return;
                }
            }
            catch(Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static boolean hasAvailableCar() {
        for(int i=0; i<cars.length; i++) {
            if(cars[i].isAvailable()) {
                return true;
            }
        }
        return false;
    }





}
