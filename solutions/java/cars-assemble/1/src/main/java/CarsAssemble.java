public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        if (speed == 0) {
            return 0;
        } else if (speed <= 4) {
            return speed * 221;
        } else if (speed <= 8) {
            return speed * 0.9 * 221;
        } else if (speed == 9){
            return speed * 0.8 * 221;
        } else {
            return speed * 0.77 * 221;
        }
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
