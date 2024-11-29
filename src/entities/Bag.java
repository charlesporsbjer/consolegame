import java.util.ArrayList;

public class Bag {
    private double weightCapacity;
    private ArrayList<Item> bag;

    public Bag(double weightCapacity) {
        this.bag = new ArrayList<>();
        this.weightCapacity = weightCapacity;
    }

    private double getWeightCapacity() {
        return weightCapacity;
    }

    public void check(){
        if(bag.isEmpty()){
            System.out.println("Bag is empty.");
        }
        else{
            for(Item anItem : bag){
                System.out.println(anItem);
            }
        }
    }
}
