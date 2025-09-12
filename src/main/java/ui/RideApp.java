package ui;

import model.Ride;
import service.RideLoader;
import service.RideSelector;

import java.util.List;
import java.util.Scanner;

public class RideApp {
    public static void main(String[] args) {
        String path = "src/main/resources/rides.json";
        List<Ride> rides = RideLoader.loadFromJson(path);

        System.out.println("🎢 Disneyland Ride Selector");
        System.out.println("Top thrill rides (7+):");
        for (Ride ride : RideSelector.getTopThrillRides(rides, 7)) {
            System.out.println("- " + ride.getName() + " - Thrill Level: " + ride.getThrillLevel());
        }

        // Run test method
        RideLoader.testJsonLoad(path);

        // Start interactive menu
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View all rides");
            System.out.println("2. Filter by ride type");
            System.out.println("3. Filter by minimum thrill level");
            System.out.println("4. Surprise me!");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    printRides(rides);
                    break;
                case "2":
                    System.out.print("Enter ride type (e.g., Transport, Show, Ride, Walkthrough): ");
                    String type = scanner.nextLine();
                    printRides(RideSelector.filterByType(rides, type));
                    break;
                case "3":
                    System.out.print("Enter minimum thrill level (1–5): ");
                    try {
                        int level = Integer.parseInt(scanner.nextLine());
                        printRides(RideSelector.getTopThrillRides(rides, level));
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Invalid number. Please enter an integer.");
                    }
                    break;
                case "4":
                    System.out.print("Enter minimum thrill level (or press Enter to skip): ");
                    String input = scanner.nextLine();
                    List<Ride> pool;

                    if (input.isEmpty()) {
                        pool = rides;
                    } else {
                        try {
                            int minLevel = Integer.parseInt(input);
                            pool = RideSelector.getTopThrillRides(rides, minLevel);
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️ Invalid input. Showing random ride from all.");
                            pool = rides;
                        }
                    }

                    if (pool.isEmpty()) {
                        System.out.println("⚠️ No rides match your criteria.");
                    } else {
                        Ride surprise = pool.get((int) (Math.random() * pool.size()));
                        System.out.println("🎉 Surprise Ride: " + surprise.getName() + " (" + surprise.getType() + ") - Thrill Level: " + surprise.getThrillLevel());
                    }
                    break;
                case "5":
                    running = false;
                    System.out.println("👋 Thanks for using the Ride Selector. Have a magical day!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void printRides(List<Ride> rides) {
        if (rides.isEmpty()) {
            System.out.println("⚠️ No rides found.");
        } else {
            for (Ride ride : rides) {
                System.out.println("- " + ride.getName() + " (" + ride.getType() + ") - Thrill Level: " + ride.getThrillLevel());
            }
        }
    }
}