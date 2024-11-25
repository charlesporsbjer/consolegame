/* Parser Class

The parser should:
    Accept a string input from the player.
    Split the input into actionable parts (e.g., command and arguments).
    Validate the command against a list of acceptable commands.
    Return a result or trigger the corresponding action. 

    */

    import java.util.*;

    public class Parser {
        // Synonyms for commands
        private static final Map<String, String> synonyms = Map.of(
            "WALK", "GO",
            "MOVE", "GO",
            "LOOK AROUND", "LOOK"
        );
    
        // Resolve synonyms to canonical commands
        private static String resolveSynonym(String command) {
            return synonyms.getOrDefault(command.toUpperCase(), command.toUpperCase());
        }
    
        // Validate if a command is valid
        public static boolean isValidCommand(String command) {
            try {
                Command.valueOf(command.toUpperCase());
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
    
        // Parse user input into command and arguments
        public static ParsedCommand parse(String userInput) {
            userInput = userInput.trim();
            String[] parts = userInput.split("\\s+", 2);
            String command = resolveSynonym(parts[0]);
            String arguments = parts.length > 1 ? parts[1] : "";
    
            if (!isValidCommand(command)) {
                System.out.println("Error: Invalid command. Type 'help' for valid commands.");
                return null;
            }
    
            return new ParsedCommand(command, arguments);
        }
    
        // Generate help text
        public static void printHelp() {
            System.out.println("Available commands:");
            for (Command cmd : Command.values()) {
                System.out.println("- " + cmd.toString().toLowerCase());
            }
        }
    }