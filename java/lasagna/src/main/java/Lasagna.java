import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Lasagna {
    public int expectedMinutesInOven(){
        return 40;
    }

    public int remainingMinutesInOven(int timeInOven){
        return expectedMinutesInOven() - timeInOven;
    }

    public int preparationTimeInMinutes(int numberOfLayers){
        return numberOfLayers * 2;
    }

    public int totalTimeInMinutes(int numberOfLayers, int timeInOven){
        String s = "";
        s.substring(1);
        return preparationTimeInMinutes(numberOfLayers) + expectedMinutesInOven() - remainingMinutesInOven(timeInOven);
    }

    static void main() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh a", Locale.UK);
        System.out.println(formatter.format(LocalDateTime.now()));
    }
}