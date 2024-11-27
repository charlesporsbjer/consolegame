package engine;


public class CommandExecutor {
    private final GameState gameState;

    public CommandExecutor(GameState gameState) {
        this.gameState = gameState;
    }

    public void execute(ParsedCommand command) {
        switch (command.getCommand().toUpperCase()) {
            case "GO":
            case "WALK":
            case "MOVE":
                handleGo(command.getArguments());
                break;
            case "LOOK":
            case "LOOK AROUND":
                handleLook();
                break;
            case "QUIT":
                handleQuit();
                break;
            default:
                System.out.println("Unknown command: " + command.getCommand());
        }
    }
    

    // Example command handler methods
    private void handleGo(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Where do you want to go?");
        } else {
            System.out.println("You move " + direction + ".");
            gameState.movePlayer(direction); // Updates the game state
        }
    }

    private void handleLook() {
        System.out.println("You look around.");
        System.out.println(gameState.getCurrentLocationDescription());
    }

    private void handleTake(String item) {
        if (item.isEmpty()) {
            System.out.println("What do you want to take?");
        } else {
            System.out.println("You pick up the " + item + ".");
            gameState.addItemToInventory(item);
        }
    }

    private void handleInventory() {
        System.out.println("Your inventory: " + gameState.getInventory());
    }

    private void handleHelp() {
        System.out.println("Available commands: GO, LOOK, TAKE, INVENTORY, HELP, QUIT.");
    }

    private void handleQuit() {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }
}
