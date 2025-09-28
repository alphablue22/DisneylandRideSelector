package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import model.Ride;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Utility class responsible for loading ride data from a JSON file.
 * Uses Jackson for deserialization into a list of Ride objects.
 */
public class RideLoader {

    /**
     * Loads a list of Ride objects from a JSON file at the specified path.
     *
     * @param filePath the path to the JSON file containing ride data
     * @return a list of Ride objects, or an empty list if loading fails
     */
    public static List<Ride> loadFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper(); // Jackson object mapper for JSON parsing

        try {
            // Deserialize JSON array into a list of Ride objects
            return mapper.readValue(new File(filePath), new TypeReference<List<Ride>>() {});
        } catch (IOException e) {
            // Print error message and return empty list if file loading fails
            System.err.println("Failed to load rides from JSON: " + e.getMessage());
            return List.of(); // Return empty list on failure
        }
    }

    /**
     * Test method to verify that ride data can be successfully loaded from JSON.
     * Prints the number of rides loaded and the first ride's name and type.
     *
     * @param filePath the path to the JSON file to test
     */
    public static void testJsonLoad(String filePath) {
        List<Ride> rides = loadFromJson(filePath);

        if (rides.isEmpty()) {
            System.out.println("❌ No rides loaded. Check your JSON file or path.");
        } else {
            System.out.println("✅ Loaded " + rides.size() + " rides.");
            System.out.println("First ride: " + rides.get(0).getName() + " (" + rides.get(0).getType() + ")");
        }
    }
}