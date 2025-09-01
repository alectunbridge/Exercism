public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double efficiency;
        if (speed == 0) {
            efficiency = 0;
        } else if (speed <= 4) {
            efficiency = 1;
        } else if (speed <= 8) {
            efficiency = 0.9;
        } else if (speed == 9){
            efficiency = 0.8;
        } else {
            efficiency = 0.77;
        }
        return speed * efficiency * 221;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
