import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {

    public static final Pattern LOG_LINE_PATTERN = Pattern.compile("\\[(.+)]: (.*)", Pattern.DOTALL);

    public static String message(String logLine) {
        Matcher matcher = LOG_LINE_PATTERN.matcher(logLine);
        matcher.matches();
        return matcher.group(2).trim();
    }

    public static String logLevel(String logLine) {
        Matcher matcher = LOG_LINE_PATTERN.matcher(logLine);
        matcher.matches();
        return matcher.group(1).trim().toLowerCase();
    }

    public static String reformat(String logLine) {
        return "%s (%s)".formatted(message(logLine), logLevel(logLine));
    }
}
