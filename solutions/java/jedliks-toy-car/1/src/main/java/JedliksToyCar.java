public class JedliksToyCar {
    private int distance;
    private int charge = 100;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distance + " meters";
    }

    public String batteryDisplay() {
        if (charge > 0) {
            return "Battery at " + charge + "%";
        }
        return "Battery empty";
    }

    public void drive() {
        if (charge > 0) {
            distance += 20;
            charge--;
        }
    }
}
