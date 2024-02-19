import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class OrderDateTime {
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
    public String getCurrentDateTime() {
        LocalDateTime date = LocalDateTime.now();
        return dateFormat.format(date);
    }
    public long getMinutesDifference(String dateTimeString) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, dateFormat);
        return ChronoUnit.MINUTES.between(parsedDateTime, currentDateTime);
    }

}
