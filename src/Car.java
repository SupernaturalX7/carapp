public class Car extends Engine {

    private String leftPanelColor;
    private String rightPanelColor;
    private String frontPanelColor;
    private String backPanelColor;
    private int doors;
    private int frontSeats;
    private int backSeats;
    private MATERIAL material;
    private String tireType;
    private String engineType;

    public Car() {
        this(2, 3, 0);
    }

    public Car(int doors, int frontSeats, int backSeats) {
        setDoors(doors);
        setFrontSeats(frontSeats);
        setBackSeats(backSeats);
        setEngineType();

    }

    public Car setLeftPanelColor(String leftPanelColor) {
        this.leftPanelColor = leftPanelColor;
        return this;
    }

    public Car setRightPanelColor(String rightPanelColor) {
        this.rightPanelColor = rightPanelColor;
        return this;
    }

    public Car setFrontPanelColor(String frontPanelColor) {
        this.frontPanelColor = frontPanelColor;
        return this;
    }

    public Car setBackPanelColor(String backPanelColor) {
        this.backPanelColor = backPanelColor;
        return this;
    }

    private void setDoors(int doors) {
        if (doors % 2 == 0 && doors <= 4) {
            this.doors = doors;
        } else {
            throw new RuntimeException("Sorry, must be a reasonable amount of doors, ya fool");
        }
    }

    private void setFrontSeats(int frontSeats) {
        if (!(frontSeats > 3) && !(frontSeats < 2)) {
            this.frontSeats = frontSeats;
        } else {
            throw new RuntimeException("Sorry, must be a reasonable amount of front seats, ya fool");
        }
    }

    private void setBackSeats(int backSeats) {
        if (!(backSeats > 3) && !(backSeats < 2)) {
            this.backSeats = backSeats;
        } else if (doors == 2 && backSeats == 0) {
            this.backSeats = backSeats;
        } else {
            throw new RuntimeException("Sorry, must be a reasonable amount of back seats, ya fool");
        }
    }

    public void isLeather(MATERIAL material) {
        if (material == MATERIAL.LEATHER) {
            this.material = MATERIAL.valueOf("LEATHER");
        } else if (material == MATERIAL.POLYESTER) {
            this.material = MATERIAL.valueOf("POLYESTER");
        }
    }

    public void setTireType(TIRE tireType) {
        switch (tireType) {
            case ALLSEASON:
                this.tireType = "All Season";
                break;
            case WINTER:
                this.tireType = "Winter";
                break;
            case DRIFT:
                this.tireType = "Drift";
                break;
            case RACING:
                this.tireType = "Racing";
                break;
        }
    }

    private void setEngineType() {
        this.engineType = super.getEngine();
    }

    public enum MATERIAL {
        LEATHER, POLYESTER
    }

    public enum TIRE {
        ALLSEASON, RACING, DRIFT, WINTER
    }

    public void carSummary() {
        System.out.println("Colors: \n" +
                "Front: " + frontPanelColor + ",\n" +
                "Left: " + leftPanelColor + ",\n" +
                "Right: " + rightPanelColor + ",\n" +
                "Back: " + backPanelColor + ",\n" +
                "Number of doors: " + doors + ",\n" +
                "Number of front seats: " + frontSeats + ",\n" +
                "Number of back seats: " + backSeats + ",\n" +
                "Material: " + material + ",\n" +
                "Tires installed: " + tireType + ",\n" +
                "Engine type: " + engineType);
    }
}
