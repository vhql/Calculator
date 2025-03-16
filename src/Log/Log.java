package Log;

import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

public class Log {
    private static final Path logPath = Paths.get("log.txt");
    public static void log(double result, String expression){
        SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = TimeFormat.format(new Date());
        String LogMessage = String.format("%s %s = %.3f",timestamp,expression,result);
        try {
            Files.write(logPath, Collections.singletonList(LogMessage), StandardCharsets.UTF_8,
                    Files.exists(logPath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
            System.out.println("log saved\n" + LogMessage);
        } catch (IOException e){
            System.out.println("writing error" + e.getMessage());
        }
    }
    public static void clearLog() {
        try {
            Files.write(logPath, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Log file cleared.");
        } catch (IOException e) {
            System.out.println("Error clearing log file: " + e.getMessage());
        }
    }
    public static void readLastExpression() {
        try {
            List<String> lines = Files.readAllLines(logPath, StandardCharsets.UTF_8);
            if (!lines.isEmpty()) {
                String lastLog = lines.get(lines.size() - 1);
                String expression = lastLog.substring(lastLog.indexOf(" ", lastLog.indexOf(" ") + 1) + 1);
                System.out.println("Last Expression: " + expression);
            }
            else {
                System.out.println("Log file is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }
    }
}
