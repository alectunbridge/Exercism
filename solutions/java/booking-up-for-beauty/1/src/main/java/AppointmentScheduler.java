import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.LocalTime.*;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, dtf);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalTime appointmentTime = appointmentDate.toLocalTime();
        return appointmentTime.isAfter(NOON) && appointmentTime.isBefore(LocalTime.of(18,0))
                || appointmentTime.equals(NOON);
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter outputDateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy,");//at H:mm a");
        DateTimeFormatter outputTimeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        return "You have an appointment on " + appointmentDate.format(outputDateFormatter)
                + " at " + appointmentDate.format(outputTimeFormatter).toUpperCase() + ".";
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }
}
