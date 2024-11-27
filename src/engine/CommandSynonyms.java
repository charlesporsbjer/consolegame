package engine;/*
 * This class manages the synonyms for various game commands and provides functionality to 
 * parse user input for recognized commands. It uses a `Map` to associate each command with 
 * a set of synonyms, allowing the user to type commands in various forms (e.g., "go", "move", 
 * or "travel" all map to the "GO" command). 
 * 
 * The key methods in this class include:
 * 1. `isCommandSynonym(String command, String word)`: Checks if a given word is a synonym for 
 *    a specific command.
 * 2. `getCommandFromTokens(List<String> tokens)`: Takes a list of tokens (words) from the user 
 *    input and returns the first recognized command based on the defined synonyms.
 *
 */

import java.util.*;

public class CommandSynonyms {
    // Map command name to a list of synonyms
    private static final Map<String, Set<String>> commandSynonyms = new HashMap<>();

    static {
        /* MOVEMENTS */
        
        // Synonyms for the "GO" command
        commandSynonyms.put("GO", new HashSet<>(Arrays.asList("go", "walk", "travel",
                "head", "venture", "move", "advance", "depart", "wander", "stride",
                "march", "trek", "hike", "pace")));
    
        // Synonyms for the "ASCEND" command
        commandSynonyms.put("ASCEND", new HashSet<>(Arrays.asList("climb", "ascend", "scale",
                "clamber", "scramble", "mount", "up")));

        // Synonyms for the "DESCEND" command
        commandSynonyms.put("DESCEND", new HashSet<>(Arrays.asList("descend", "down", "drop",
                "decline", "sink", "fall")));
        
        /* ACTIONS */

        // Synonyms for the "PUT" command
        commandSynonyms.put("PUT", new HashSet<>(Arrays.asList("put", "store", "place", "deposit",
                "stow", "stash")));

        // Synonyms for the "TAKE" command
        commandSynonyms.put("TAKE", new HashSet<>(Arrays.asList("take", "get", "grab",
                "seize", "collect", "fetch", "pick up", "remove")));

        // Synonyms for the "LOOK" command
        commandSynonyms.put("LOOK", new HashSet<>(Arrays.asList("look", "examine", "check",
                "view", "peek", "peer", "watch", "observe", "spot", "scan", "inspect", "study",
                "analyze", "investigate")));
        
    }

    // Check if a word is a synonym of a command
    public static boolean isCommandSynonym(String command, String word) {
        Set<String> synonyms = commandSynonyms.get(command);
        return synonyms != null && synonyms.contains(word.toLowerCase());
    }

    // Get the main command from a list of tokens (guesses the first matching command)
    public static String getCommandFromTokens(List<String> tokens) {
        for (String token : tokens) {
            for (String command : commandSynonyms.keySet()) {
                if (isCommandSynonym(command, token)) {
                    return command;
                }
            }
        }
        return null;  // No valid command found
    }
}
