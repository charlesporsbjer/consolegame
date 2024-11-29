import java.util.*;

public class Room {
    private HashMap<Direction, Room> exits;
    private String description;
    private String name;
    private Container aContainer;

    public Room(String name){
        exits = new HashMap<Direction, Room>();
        this.name = name;
    }

    public Room(String name, String description){
        this(name);
        this.description = description;
    }

    public Room(String name, String description, String containerName){
        this(name, description);
        this.description = description;
        aContainer = new Container(containerName, false);
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
        String output = "--<[" + name + "]>-- \n" + formatDescription();

        return output;
    }

    public Container getContainer(){
        return aContainer;
    }

    //Setters
    public void setExit(Direction direction, Room neighboringRoom){
        if(!hasExit(direction)){
            exits.put(direction, neighboringRoom);

            /*This adds the current room to the neighboring rooms HashMap of exits
            thus linking rooms together. */
            if(!neighboringRoom.hasExit(Direction.getOpposite(direction))){
                neighboringRoom.setExit(Direction.getOpposite(direction), this);
            }
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
        return exits.containsKey(aDirection);
    }

    public boolean hasContainer(){
        return aContainer != null;
    }

    private String formatDescription(){
        int wordCount = 0;
        StringBuilder output = new StringBuilder();
        ArrayList<String> outputArr = new ArrayList<>(Arrays.asList(description.split(" ")));
        Iterator<String> i = outputArr.iterator();

        while(i.hasNext()){
            output.append(i.next());
            if(i.hasNext()){
                output.append(" ");
            }
            if(wordCount > 9 && wordCount % 10 == 0){
                output.append("\n");
            }
            wordCount++;
        }

        return output.toString();
    }

    public String toString(){
        return "--<[" + name + "]>--";
    }

}
