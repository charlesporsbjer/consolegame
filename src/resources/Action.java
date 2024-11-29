import java.util.HashMap;
import java.util.Iterator;

public enum Action {
    GO("Go"),
    STORE("Store"),
    LOOK("Look"),
    EXAMINE("Examine"),
    HELP("Help"),
    QUIT("Quit"),
    TALK("Talk"),
    CHECK("Check"),
    UNKNOWN("Unknown");

    private final String actionName;

    private Action(String actionName) {
        this.actionName = actionName;
    }

    public String toString(){
        return actionName;
    }

    public static HashMap<String, Action> getActions(){
        HashMap<String, Action> actions = new HashMap<>();
        for(Action action : Action.values()){
            if(action != UNKNOWN){
                actions.put(action.toString(), action);
            }
        }
        return actions;
    }

    public static Action getAction(String word){
        if(word == null){
            return UNKNOWN;
        }
        for(String actionName : getActions().keySet()){
            if(word.equalsIgnoreCase(actionName)){
                return getActions().get(actionName);
            }
        }
        return UNKNOWN;
    }

    public static void showAll(){
        Iterator<String> it = getActions().keySet().iterator();
        while(it.hasNext()){
            System.out.print(it.next());
            if(it.hasNext()){
                System.out.print(", ");
            }
            else{
                System.out.println(".");
            }
        }
    }
}
