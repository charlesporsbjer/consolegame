package resources;

import engine.Direction;
import java.util.HashMap;
import java.util.Iterator;

public class Room {
    private HashMap<Direction, Room> exits;
    private String description;
    private String name;

    public Room(String name){
        exits = new HashMap<>();
        this.name = name;
    }

    public Room(String name, String description){
        this(name);
        this.description = description;
    }

    //Getters
    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public Room getExit(Direction direction){
        return exits.get(direction);
    }

    public String getExitString(){
        String output = "";
        Iterator<Direction> i = exits.keySet().iterator();

        while(i.hasNext()){
            output += i.next();
            if(i.hasNext()){
                output += ", ";
            }
            else{
                output += ".";
            }
        }
        return output;
    }

    public HashMap<Direction, Room> getExits(){
        return exits;
    }

    public String getLongDescription(){
        return name + ": " + description;
    }

    //Setters
    public void setExit(Direction direction, Room neighboringRoom){
        exits.put(direction, neighboringRoom);

        /*This adds the current room to the neighboring rooms HashMap of exits
        thus linking rooms together. */
        if(!neighboringRoom.hasExit(Direction.getOpposite(direction))){
            neighboringRoom.setExit(Direction.getOpposite(direction), this);
        }
    }

    public void setName(String newName){
        name = newName;
    }

    public void setDescription(String newDescription){
        description = newDescription;
    }

    //Misc
    public boolean hasExit(Direction aDirection){
        return getExits().containsKey(aDirection);
    }


}
