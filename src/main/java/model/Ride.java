package model;

public class Ride {
    private String name;
    private String land;
    private int thrillLevel;
    private String type;

    // No-arg constructor
    public Ride() {}

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLand() { return land; }
    public void setLand(String land) { this.land = land; }

    public int getThrillLevel() { return thrillLevel; }
    public void setThrillLevel(int thrillLevel) { this.thrillLevel = thrillLevel; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return name + " (" + land + ") - " + type + ", Thrill Level: " + thrillLevel;
    }
}