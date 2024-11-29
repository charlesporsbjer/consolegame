import java.util.Scanner;
import java.util.HashMap;
public class Parser {
    private final HashMap<String, Direction> directions;
    private final HashMap<String, Action> actions;
    private final Scanner reader;

    public Parser(){
        directions = Direction.getDirections();
        actions = Action.getActions();
        reader = new Scanner(System.in);
    }

    public Command getCommand(){
        String inputLine; // will hold the full input line
        String word1 = null;
        String word2 = null;
        //String word3; [PLACEHOLDER]

        //prompt user
        System.out.print("> ");

        inputLine = reader.nextLine();

        //Find up to two (later three) words on the line
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()){
            word1 = tokenizer.next();
            if(tokenizer.hasNext()){
                word2 = tokenizer.next();
                if(isDirection(word2)){
                    return new Command(Action.getAction(word1), Direction.getDirection(word2));
                }
                else{
                    return new Command(Action.getAction(word1), word2);
                }
            }
        }
        return new Command(Action.getAction(word1), word2);
    }

    public boolean isDirection(String word){
        for(String direction : directions.keySet()){
            if(word.equalsIgnoreCase(direction)){
                return true;
            }
        }
        return false;
    }

    public boolean isAction(String word){
        for(String action : actions.keySet()){
            if(word.equalsIgnoreCase(action)){
                return true;
            }
        }
        return false;
    }

    public void showDirections(){
        Direction.showAll();
    }

    public void showActions(){
        Action.showAll();
    }
}
