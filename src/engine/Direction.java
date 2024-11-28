package engine;

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
    DOWN("Down");

    final String directionName;

    Direction(String directionName){
        this.directionName = directionName;
    }

    public String getDirectionName(){
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
        };
    }
}
