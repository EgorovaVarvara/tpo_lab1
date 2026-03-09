package itmo.models;

public class Bombing extends Object{

    private boolean isStarted;

    public Bombing (String name){
        super(name);
        isStarted = false;
    }

    public boolean getStarted(){
        return isStarted;
    }

    public void setStarted (boolean isStarted){
        this.isStarted = isStarted;
    }
}
