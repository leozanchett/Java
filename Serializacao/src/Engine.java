public class Engine {
    private double liters;
    private int cylinders;

    public Engine(double liters, int cylinders) {
        this.liters = liters;
        this.cylinders = cylinders;
    }

    public double getLiters() {
        return liters;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "liters=" + liters +
                ", cylinders=" + cylinders +
                '}';
    }
}
