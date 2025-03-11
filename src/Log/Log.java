package Log;

import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

public class Log {
    public static void log(double result, String expression){
        SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = TimeFormat.format(new Date());
        String LogMessage = String.format("%s %s = %.3f",timestamp,expression,result);
        Path logPath = Paths.get("log.txt");
        try {
            Files.write(logPath, Collections.singletonList(LogMessage), StandardCharsets.UTF_8,
                    Files.exists(logPath) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
            System.out.println("log saved\n" + LogMessage);
        } catch (IOException e){
            System.out.println("writing error" + e.getMessage());
        }
    }
}
