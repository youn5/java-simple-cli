public class CommandLine {

    private String commandName;
    private String commandArgument;

    public CommandLine(String commandLine) {
        String[] array = commandLine.trim().split(" ", 2);
        commandName = array[0];
        commandArgument = array.length > 1 ? array[1] : null;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getCommandArgument() {
        return commandArgument;
    }

    public boolean hasArgument() {
        return commandArgument != null;
    }
}
