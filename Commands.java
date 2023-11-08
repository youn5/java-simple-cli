import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

import java.io.IOException;

public class Commands {

    public static String date(CommandLine commandLine) {
        return LocalDate.now().toString();
    }

    public static String time(CommandLine commandLine) {
        return LocalTime.now().toString();
    }

    public static String datetime(CommandLine commandLine) {
        return LocalDateTime.now().toString();
    }

    public static String useraccount(CommandLine commandLine) {
        return System.getProperty("user.name");
    }

    public static String userhome(CommandLine commandLine) {
        return System.getProperty("user.home");
    }

    public static String os(CommandLine commandLine) {
        return System.getProperty("os.name") + " " + "(" + System.getProperty("os.version") + ")";
    }

    public static String printenv(CommandLine commandLine) {
        if (commandLine.hasArgument()) {
            String envValue = System.getenv(commandLine.getCommandArgument());
            return envValue != null ? envValue : "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String key : System.getenv().keySet()) {
                sb.append(key).append("=").append(System.getenv(key)).append(System.lineSeparator());
            }
            return sb.toString();
        }
    }

    public static String echo(CommandLine commandLine) {
        return commandLine.hasArgument() ? commandLine.getCommandArgument() : "";
    }

    public static String ls(CommandLine commandLine) {
        if (commandLine.hasArgument()) {
            File dir = new File(commandLine.getCommandArgument());
            if (dir.isDirectory()) {
                StringBuilder sb = new StringBuilder();
                for (File file : dir.listFiles()) {
                    sb.append(file.getName()).append(System.lineSeparator());
                }
                return sb.toString();
            }
        }
        return "Not a directory";
    }

    public static String cat(CommandLine commandLine) {
        if (commandLine.hasArgument()) {
            File file = new File(commandLine.getCommandArgument());
            if (file.isFile()) {
                try {
                    List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
                    StringBuilder sb = new StringBuilder();
                    int lineNumber = 1;
                    for (String line : lines) {
                        sb.append(lineNumber).append(". ").append(line).append(System.lineSeparator());
                        lineNumber++;
                    }
                    return sb.toString();
                } catch (IOException e) {
                    return "Error reading file";
                }
            } else {
                return "Not a file";
            }
        } else {
            return "Please specify a path to a text file to read";
        }
    }
}
