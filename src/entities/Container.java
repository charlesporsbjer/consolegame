import java.util.ArrayList;

public class Container {
    private static int IDHolder = 1;
    private final int ID;
    private String name;
    private ArrayList<Item> containersItems;
    private boolean isLocked;

    public Container(String name, boolean isLocked){
        ID = IDHolder;
        this.name = name;
        this.containersItems = new ArrayList<>();
        this.isLocked = isLocked;
        IDHolder++;
    }

    public int getID(){
        return ID;
    }

    public ArrayList<Item> getContainerItems(){
        return containersItems;
    }

    public void addItem(Item item){
        containersItems.add(item);
    }

    public void removeItem(Item item){
        containersItems.remove(item);
    }

    public Item takeItem(String name){
        for(Item anItem : containersItems){
            if(anItem.getName().equals(name)){
                return anItem;
            }
        }
        return null;
    }

    public String ToString(){
        return name;
    }

    public String getName(){
        return name;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void showContents(){
        if(containersItems.isEmpty()){
            System.out.println(name + " is empty.");
        }
        else{
            System.out.println("[" + name + "] contains:");
            for(Item item : containersItems){
                System.out.println(item);
            }
        }
    }

    public void unlock(){
        if(!isLocked()){
            System.out.println(name + " is already unlocked.");
        }
        else{
            isLocked = false;
        }
    }

    public void lock(){
        if(this.isLocked){
            System.out.println(name + " is already locked.");
        }
        else{
            this.isLocked = true;
        }
    }
}
