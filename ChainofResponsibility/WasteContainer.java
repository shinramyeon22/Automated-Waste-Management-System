package ChainofResponsibility;
public class WasteContainer {
    private String type;
    private double capacity;
    private double currentLevel;

    public WasteContainer(String type, double capacity) {
        this.type = type.toLowerCase();
        this.capacity = capacity;
        this.currentLevel = 0.0;
    }

    public String getType() {
        return type;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    public void addWaste(double amount) {
        currentLevel += amount;
        if (currentLevel > capacity) {
            currentLevel = capacity;
        }
    }

    public boolean needsDisposal() {
        return currentLevel >= capacity * 0.80;
    }

    public void dispose() {
        System.out.println("→ Disposed: " + type + " waste  ("
                + String.format("%.1f", currentLevel) + " / "
                + String.format("%.1f", capacity) + ")");
        currentLevel = 0.0;
    }
}