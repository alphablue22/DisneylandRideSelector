package ui;

import model.Ride;
import service.RideLoader;
import service.RideSelector;

import java.util.*;

/**
 * Main class for the Disneyland Ride Selector CLI application.
 * Provides interactive options for filtering, exploring, and tracking rides.
 */
public class RideApp {
    public static void main(String[] args) {
        // Load ride data from JSON file
        String path = "src/main/resources/rides.json";
        List<Ride> rides = RideLoader.loadFromJson(path);

        // Track which rides have been marked as ridden
        Set<String> riddenRides = new HashSet<>();

        // Initial preview of top thrill rides
        System.out.println("🎢 Disneyland Ride Selector");
        System.out.println("Top thrill rides (7+):");
        for (Ride ride : RideSelector.getTopThrillRides(rides, 7)) {
            System.out.println("- " + ride.getName() + " - Thrill Level: " + ride.getThrillLevel());
        }

        // Run test method to confirm JSON load
        RideLoader.testJsonLoad(path);

        // Start interactive CLI menu
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View all rides");
            System.out.println("2. Filter by ride type");
            System.out.println("3. Filter by minimum thrill level");
            System.out.println("4. Filter by land");
            System.out.println("5. Mark ride as ridden");
            System.out.println("6. View ridden rides");
            System.out.println("7. Surprise me!");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    printRides(rides);
                    break;

                case "2":
                    System.out.print("Enter ride type (e.g., Thrill, Family, Adventure): ");
                    String type = scanner.nextLine();
                    printRides(RideSelector.filterByType(rides, type));
                    break;

                case "3":
                    System.out.print("Enter minimum thrill level (1–10): ");
                    try {
                        int level = Integer.parseInt(scanner.nextLine());
                        printRides(RideSelector.getTopThrillRides(rides, level));
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Invalid number. Please enter an integer.");
                    }
                    break;

                case "4":
                    System.out.print("Enter land name (e.g., Tomorrowland, Fantasyland): ");
                    String land = scanner.nextLine();
                    printRides(RideSelector.filterByLand(rides, land));
                    break;

                case "5":
                    System.out.print("Enter ride name to mark as ridden: ");
                    String ridden = scanner.nextLine();
                    riddenRides.add(ridden);
                    System.out.println("✅ Marked " + ridden + " as ridden.");
                    break;

                case "6":
                    if (riddenRides.isEmpty()) {
                        System.out.println("🚫 No rides marked as ridden.");
                    } else {
                        System.out.println("🎟️ Ridden rides:");
                        for (String name : riddenRides) {
                            System.out.println("- " + name);
                        }
                    }
                    break;

                case "7":
                    System.out.print("Enter minimum thrill level (or press Enter to skip): ");
                    String input = scanner.nextLine();
                    List<Ride> pool;

                    // Filter by thrill level if provided
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

                    // Exclude ridden rides
                    pool = RideSelector.excludeRidden(pool, riddenRides);

                    if (pool.isEmpty()) {
                        System.out.println("⚠️ No rides match your criteria.");
                    } else {
                        Ride surprise = pool.get((int) (Math.random() * pool.size()));
                        System.out.println("🎉 Surprise Ride: " + surprise);
                    }
                    break;

                case "8":
                    running = false;
                    System.out.println("👋 Thanks for using the Ride Selector. Have a magical day!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    /**
     * Prints a list of rides to the console.
     *
     * @param rides the list of rides to display
     */
    private static void printRides(List<Ride> rides) {
        if (rides.isEmpty()) {
            System.out.println("⚠️ No rides found.");
        } else {
            for (Ride ride : rides) {
                System.out.println("- " + ride);
            }
        }
    }
}