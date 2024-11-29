import java.util.HashMap;
import java.util.Iterator;

public enum Direction {
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West"),
    NORTHWEST("North West"),
    NORTHEAST("North East"),
    SOUTHWEST("South West"),
    SOUTHEAST("South East"),
    UP("Up"),
    DOWN("Down"),
    UNKNOWN("Unknown");

    final String directionName;

    Direction(String directionName){
        this.directionName = directionName;
    }

    public String toString(){
        return directionName;
    }

    public static Direction getOpposite(Direction aDirection){
        return switch (aDirection) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
            case UP -> DOWN;
            case DOWN -> UP;
            case NORTHWEST -> SOUTHEAST;
            case NORTHEAST -> SOUTHWEST;
            case SOUTHEAST -> NORTHWEST;
            case SOUTHWEST -> NORTHEAST;
            case UNKNOWN -> UNKNOWN;
        };
    }

    public static HashMap<String, Direction> getDirections(){
        HashMap<String, Direction> directions = new HashMap<>();
        for(Direction direction : Direction.values()){
            directions.put(direction.toString(), direction);
        }
        return directions;
    }

    public static Direction getDirection(String word){
        if(word == null){
            return UNKNOWN;
        }
        for(String directionName : getDirections().keySet()){
            if(word.equalsIgnoreCase(directionName)){
                return getDirections().get(directionName);
            }
        }
        return UNKNOWN;
    }

    public static void showAll(){
        Iterator<Direction> it = getDirections().values().iterator();
        while(it.hasNext() && it.next() != UNKNOWN){
            System.out.print(it.next());
            if(it.hasNext()){
                System.out.print(", ");
            }
            else{
                System.out.print(".");
            }
        }
    }
}
