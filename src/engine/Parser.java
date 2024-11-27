/* 
 * The Parser class is responsible for handling user input in the game.
 * It performs the following tasks:
 * 
 * 1. Accepts a string of input from the user.
 * 2. Splits the input into individual tokens (words).
 * 3. Identifies the main command (e.g., "GO", "PUT", etc.) by checking the tokens against a list of known command synonyms.
 * 4. Extracts the command-specific arguments (e.g., direction, items, etc.) from the remaining tokens.
 * 5. Delegates the command execution to the CommandExecutor class, passing the identified command and its arguments.
 * 
 */

    import engine.CommandSynonyms;
    import engine.CommandExecutor;
    import java.util.*;

    public class Parser {
    
        private CommandSynonyms commandSynonyms;
        private CommandExecutor commandExecutor;
    
        public Parser() {
            commandSynonyms = new CommandSynonyms();
            commandExecutor = new CommandExecutor();
        }
    
        // Method to parse user input and execute the corresponding commandg
        public void parseInput(String userInput) {
            // Step 1: Tokenize user input into words
            List<String> tokens = Arrays.asList(userInput.split("\\s+"));
    
            // Step 2: Get the main command from the tokens
            String command = CommandSynonyms.getCommandFromTokens(tokens);
    
            if (command == null) {
                System.out.println("I don't understand that command.");
                return;
            }
    
            // Step 3: Identify command-specific arguments (e.g., object names, directions)
            List<String> arguments = getArgumentsForCommand(command, tokens);
    
            // Step 4: Execute the command based on identified command and arguments
            executeCommand(command, arguments);
        }
    
        // Helper method to extract command arguments from the user input
        private List<String> getArgumentsForCommand(String command, List<String> tokens) {
            List<String> arguments = new ArrayList<>();
    
            // We'll consider everything after the command as arguments (simplified logic)
            boolean commandFound = false;
            for (String token : tokens) {
                if (commandFound) {
                    arguments.add(token);
                } else if (CommandSynonyms.isCommandSynonym(command, token)) {
                    commandFound = true;
                }
            }
    
            return arguments;
        }
    
        // Helper method to delegate command execution to CommandExecutor
        private void executeCommand(String command, List<String> arguments) {
            switch (command) {
                case "GO":
                    commandExecutor.executeMoveCommand(arguments);
                    break;
                case "ASCEND":
                    commandExecutor.executeAscendCommand(arguments);
                    break;
                case "DESCEND":
                    commandExecutor.executeDescendCommand(arguments);
                    break;
                case "PUT":
                    commandExecutor.executePutCommand(arguments);
                    break;
                case "TAKE":
                    commandExecutor.executeTakeCommand(arguments);
                    break;
                case "LOOK":
                    commandExecutor.executeLookCommand(arguments);
                    break;
                default:
                    System.out.println("Command not recognized.");
                    break;
            }
        }
    }