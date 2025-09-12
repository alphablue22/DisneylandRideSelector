package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import model.Ride;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RideLoader {

    public static List<Ride> loadFromJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), new TypeReference<List<Ride>>() {});
        } catch (IOException e) {
            System.err.println("Failed to load rides from JSON: " + e.getMessage());
            return List.of(); // Return empty list on failure
        }
    }

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
