package itmo.models;

public class Bombing extends Object{

    private boolean isStarted;
    private int bombimgLevel;

    public Bombing (String name, Integer bombimgLevel) {
        super(name);
        isStarted = false;
        this.bombimgLevel = bombimgLevel;
    }

    public int getBombimgLevel() {
        return bombimgLevel;
    }

    public void setBombimgLevel(int bombimgLevel) {
        this.bombimgLevel = bombimgLevel;
    }

    public boolean getStarted(){
        return isStarted;
    }

    public void setStarted (boolean isStarted){
        this.isStarted = isStarted;
    }
}
