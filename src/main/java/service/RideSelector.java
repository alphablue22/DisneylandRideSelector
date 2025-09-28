package service;

import model.Ride;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service class responsible for filtering and selecting rides based on user criteria.
 * This class contains reusable logic for thrill level, type, land, and ridden status.
 */
public class RideSelector {

    /**
     * Loads rides from a JSON file using the RideLoader utility.
     *
     * @param filePath the path to the JSON file
     * @return a list of Ride objects
     */
    public static List<Ride> loadRides(String filePath) {
        return RideLoader.loadFromJson(filePath);
    }

    /**
     * Filters rides by their type (e.g., "Thrill", "Family", "Adventure").
     *
     * @param rides the full list of rides
     * @param type the desired ride type
     * @return a filtered list of rides matching the type
     */
    public static List<Ride> filterByType(List<Ride> rides, String type) {
        return rides.stream()
                .filter(ride -> ride.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    /**
     * Filters rides by a minimum thrill level.
     *
     * @param rides the full list of rides
     * @param minThrillLevel the minimum thrill level (1–10)
     * @return a filtered list of rides with thrill level >= minThrillLevel
     */
    public static List<Ride> getTopThrillRides(List<Ride> rides, int minThrillLevel) {
        return rides.stream()
                .filter(ride -> ride.getThrillLevel() >= minThrillLevel)
                .collect(Collectors.toList());
    }

    /**
     * Filters rides by their Disneyland land (e.g., "Tomorrowland", "Fantasyland").
     *
     * @param rides the full list of rides
     * @param land the desired land name
     * @return a filtered list of rides located in the specified land
     */
    public static List<Ride> filterByLand(List<Ride> rides, String land) {
        return rides.stream()
                .filter(ride -> ride.getLand().equalsIgnoreCase(land))
                .collect(Collectors.toList());
    }

    /**
     * Excludes rides that have already been marked as ridden.
     *
     * @param rides the full list of rides
     * @param riddenRideNames a set of ride names that have been ridden
     * @return a filtered list of rides not yet ridden
     */
    public static List<Ride> excludeRidden(List<Ride> rides, Set<String> riddenRideNames) {
        return rides.stream()
                .filter(ride -> !riddenRideNames.contains(ride.getName()))
                .collect(Collectors.toList());
    }
}