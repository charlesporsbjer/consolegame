public class Game {
    private final Player mainCharacter;
    private final Parser parser;

    public Game(){
        mainCharacter = new Player("Link");
        parser = new Parser();
        initialize(mainCharacter);
    }

    public void play(){
        printWelcome();

        boolean finished = false;
        while (!finished){
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        printGoodbye();
    }

    public void initialize(Player aPlayer){
        Room room1 = new Room("Dark Cave", "It is small and dank. Further off to the " +
                "north, you see a dark hallway extending out of view.");
        Room room2 = new Room("Dark Hallway", "The walls are dark, and you can descry some mold on them.");
        Room room3 = new Room("Spacious Cavern", "The hallway opens up to a large spacious cavern, with a " +
                "rickety plankbridge crossing a chasm running through the middle of the cavern. Luminescent rocks bathes " +
                "the walls in a ghastly sheen.");
        Room room4 = new Room("Across the Plankbridge", "Having crossed the plankbridge, there yawns " +
                "before you a single black cleft in the wall.", "Rubble");
        Room room5 = new Room("Black Cleft", "It is moist and smells of filth, accumulated in innumerable years");
        room1.setExit(Direction.NORTH, room2);
        room2.setExit(Direction.EAST, room3);
        room3.setExit(Direction.NORTH, room4);
        room4.setExit(Direction.NORTH, room5);

        aPlayer.setCurrentRoom(room1);
    }

    private void printWelcome(){
        System.out.println("\n--<[PLACEHOLDER]>--\n\nYou regain consciousness and look around you.");
        mainCharacter.lookAround();
        System.out.println("Type help if you want to see your current actions!");
    }

    private void printGoodbye(){
        System.out.println("Goodbye!");
    }

    private void goRoom(Command command){
        if(!command.hasDirection()){
            System.out.println("Go where?");
        }
        else{
            //mainCharacter.move(command.getDirection());
        }

    }

    private boolean quit(Command command){
        if(!command.hasString() || !command.getThirdCommand().equalsIgnoreCase("game")){
            System.out.println("Quit what?");
            return false;
        }
        else{
            return true;
        }
    }

    private boolean processCommand(Command command){
        boolean wantToQuit = false;

        switch(command.getAction()){
            case UNKNOWN:
                System.out.println("I don't know what you mean.");
                break;
            case HELP:
                printHelp();
                break;
            case CHECK:
                mainCharacter.checkBag(command);
                break;
            case GO:
                mainCharacter.move(command);
                break;
            case LOOK:
                mainCharacter.lookAround();
                break;
            case EXAMINE:
                mainCharacter.examine(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    private void printHelp(){
        System.out.println("Your current actions are: ");
        Action.showAll();
    }

}
