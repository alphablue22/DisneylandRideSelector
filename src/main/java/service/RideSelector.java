package service;

import model.Ride;
import java.util.List;
import java.util.stream.Collectors;

public class RideSelector {

    // Load rides from JSON using RideLoader
    public static List<Ride> loadRides(String filePath) {
        return RideLoader.loadFromJson(filePath);
    }

    // Example: Filter rides by type
    public static List<Ride> filterByType(List<Ride> rides, String type) {
        return rides.stream()
                .filter(ride -> ride.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // Example: Get rides above a certain thrill level
    public static List<Ride> getTopThrillRides(List<Ride> rides, int minThrillLevel) {
        return rides.stream()
                .filter(ride -> ride.getThrillLevel() >= minThrillLevel)
                .collect(Collectors.toList());
    }
}
