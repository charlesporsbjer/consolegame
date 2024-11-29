

public class Command {
    private final Action anAction;
    private final Direction aDirection;
    private final String thirdCommand;

    public Command(Action anAction){
        this.anAction = anAction;
        aDirection = null;
        thirdCommand = null;
    }

    public Command(Action anAction, Direction aDirection) {
        this.anAction = anAction;
        this.aDirection = aDirection;
        thirdCommand = null;
    }

    public Command(Action anAction, String itemName){
        this.anAction = anAction;
        this.aDirection = null;
        this.thirdCommand = itemName;
    }

    public String getThirdCommand(){
        return thirdCommand;
    }

    public Action getAction(){
        return anAction;
    }

    public Direction getDirection(){
        return aDirection;
    }

    public boolean hasAction(){
        return anAction != null;
    }

    public boolean hasDirection(){
        return aDirection != null;
    }

    public boolean hasThirdCommand(){
        return thirdCommand != null;
    }

    public boolean directionUnknown(){
        return aDirection == Direction.UNKNOWN;
    }

    public boolean actionUnknown(){
        return anAction == Action.UNKNOWN;
    }

    //checking if the command was only one word, eg. "go"
    //and then dealing with it, eg. "go where?"
    public boolean hasSecondDirective(){
        return aDirection != null || thirdCommand != null;
    }

    public boolean hasString(){
        return thirdCommand != null;
    }
}
