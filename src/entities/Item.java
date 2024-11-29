public class Item {
    private final String name;
    private final double weight;
    private final String description;
    private final boolean canBePickedUp;

    public Item(String name, String description, double weight) {
        this.name = name;
        this.weight = weight;
        this.description = description;
        canBePickedUp = true;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.weight = 100;
        canBePickedUp = false;
    }

    public double getWeight(){
        return weight;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "[" + name + "] - " + description + "\n W: " + weight + "\n";
    }


}
