import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.File;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");

        while (true) {
            String command = scanner.nextLine();
            CommandLine commandLine = new CommandLine(command);
            String commandName = commandLine.getCommandName();
            String output = "";

            if (commandName.equals("exit") || commandName.equals("logout")) {
                break;
            } else if (commandName.equals("date")) {
                output = Commands.date(commandLine);
            } else if (commandName.equals("time")) {
                output = Commands.time(commandLine);
            } else if (commandName.equals("datetime")) {
                output = Commands.datetime(commandLine);
            } else if (commandName.equals("useraccount")) {
                output = Commands.useraccount(commandLine);
            } else if (commandName.equals("userhome")) {
                output = Commands.userhome(commandLine);
            } else if (commandName.equals("os")) {
                output = Commands.os(commandLine);
            } else if (commandName.equals("printenv")) {
                output = Commands.printenv(commandLine);
            } else if (commandName.equals("echo") || commandName.equals("print")) {
                output = Commands.echo(commandLine);
            } else if (commandName.equals("ls")) {
                output = Commands.ls(commandLine);
            } else if (commandName.equals("cat")) {
                output = Commands.cat(commandLine);
            // } else if (commandName.equals("poem")) {
            //     output = Commands.poem(commandLine);
            } else {
                output = "Command '" + commandName + "' not found.";
            }
            System.out.println(output);
            System.out.print("> ");
        }
        scanner.close();
        System.out.println("bye!");
    }
}
