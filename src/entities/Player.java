package entities;
import resources.Direction;
import resources.Room;

public class Player {

    private String name;
    private Room currentRoom;

    public Player(String name){
        this.name = name;
        currentRoom = null;
    }

    public String getName(){
        return name;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    //prints out name + description of room, and current available moves
    public void lookAround(){
        System.out.println(currentRoom.getLongDescription());
        System.out.println("Current moves: " + currentRoom.getExitString() + "\n");
    }

    public void move(Direction aDirection){
        if(currentRoom.hasExit(aDirection)){
            setCurrentRoom(currentRoom.getExit(aDirection));
            System.out.println("You move " + aDirection);
            lookAround();
        }
        else{
            System.out.println("You can't go " + aDirection);
        }
    }

}

