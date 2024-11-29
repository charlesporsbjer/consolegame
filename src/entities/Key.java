public class Key extends Item{
    private final int keyID;


    public Key(String name, String description, Container aContainer){
        super(name, description, 0.5);
        keyID = aContainer.getID();
    }

    public int getKeyID(){
        return keyID;
    }

}
