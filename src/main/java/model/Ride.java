package model;

/**
 * Represents a Disneyland ride with key attributes such as name, land, type, and thrill level.
 * This model is used throughout the application for filtering, display, and user interaction.
 */
public class Ride {

    // The name of the ride (e.g., "Space Mountain")
    private String name;

    // The themed land where the ride is located (e.g., "Tomorrowland")
    private String land;

    // The thrill level of the ride on a scale from 1 to 10
    private int thrillLevel;

    // The type of ride (e.g., "Thrill", "Family", "Adventure")
    private String type;

    /**
     * No-argument constructor required for JSON deserialization.
     * Jackson or other libraries use this to instantiate Ride objects.
     */
    public Ride() {}

    // Getter for ride name
    public String getName() {
        return name;
    }

    // Setter for ride name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for ride land
    public String getLand() {
        return land;
    }

    // Setter for ride land
    public void setLand(String land) {
        this.land = land;
    }

    // Getter for thrill level
    public int getThrillLevel() {
        return thrillLevel;
    }

    // Setter for thrill level
    public void setThrillLevel(int thrillLevel) {
        this.thrillLevel = thrillLevel;
    }

    // Getter for ride type
    public String getType() {
        return type;
    }

    // Setter for ride type
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns a formatted string representation of the ride.
     * Useful for displaying ride details in CLI or logs.
     */
    @Override
    public String toString() {
        return String.format("%s (%s) - %s, Thrill Level: %d", name, land, type, thrillLevel);
    }
}