package test;

import model.Ride;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.RideSelector;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RideSelector service class.
 * Verifies filtering logic for type, thrill level, land, and ridden exclusion.
 */
class RideSelectorTest {

    private List<Ride> sampleRides;

    /**
     * Sets up a sample list of rides before each test.
     * This ensures consistent test data across all cases.
     */
    @BeforeEach
    void setUp() {
        sampleRides = List.of(
                createRide("Space Mountain", "Tomorrowland", "Thrill", 9),
                createRide("Small World", "Fantasyland", "Family", 2),
                createRide("Indiana Jones", "Adventureland", "Thrill", 8),
                createRide("Jungle Cruise", "Adventureland", "Ride", 4)
        );
    }

    @Test
    void testFilterByType() {
        List<Ride> thrillRides = RideSelector.filterByType(sampleRides, "Thrill");
        assertEquals(2, thrillRides.size());
        assertTrue(thrillRides.stream().allMatch(r -> r.getType().equalsIgnoreCase("Thrill")));
    }

    @Test
    void testGetTopThrillRides() {
        List<Ride> topThrill = RideSelector.getTopThrillRides(sampleRides, 7);
        assertEquals(2, topThrill.size());
        assertTrue(topThrill.stream().allMatch(r -> r.getThrillLevel() >= 7));
    }

    @Test
    void testFilterByLand() {
        List<Ride> adventureRides = RideSelector.filterByLand(sampleRides, "Adventureland");
        assertEquals(2, adventureRides.size());
        assertTrue(adventureRides.stream().allMatch(r -> r.getLand().equalsIgnoreCase("Adventureland")));
    }

    @Test
    void testExcludeRidden() {
        Set<String> ridden = Set.of("Space Mountain", "Jungle Cruise");
        List<Ride> unvisited = RideSelector.excludeRidden(sampleRides, ridden);
        assertEquals(2, unvisited.size());
        assertFalse(unvisited.stream().anyMatch(r -> ridden.contains(r.getName())));
    }

    /**
     * Helper method to create a Ride object with specified attributes.
     *
     * @param name the ride name
     * @param land the land it belongs to
     * @param type the ride type
     * @param thrillLevel the thrill level (1–10)
     * @return a configured Ride object
     */
    private Ride createRide(String name, String land, String type, int thrillLevel) {
        Ride ride = new Ride();
        ride.setName(name);
        ride.setLand(land);
        ride.setType(type);
        ride.setThrillLevel(thrillLevel);
        return ride;
    }
}