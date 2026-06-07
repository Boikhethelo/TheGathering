package cards.lands;

import cards.Mana;
import cards.Status;

import java.util.ArrayList;

public abstract class Basic {
    private final ArrayList<Mana> mana;
    private final String name;
    private final String description;
    protected Status status;

    public Basic(String name , String description, ArrayList<Mana> mana){
        this.name = name;
        this.description = description;
        this.mana = new ArrayList<>(mana);

    }

    public String name(){
        return name;
    }

    public String description(){

        return description;
    }

    public Status status(){
        return status;
    }

    public Mana tap(int option){
        this.status = Status.TAPPED;
        return mana.get(option);
    }

    public void untap(){
        this.status = Status.UNTAPPED;
    }

    public abstract void placeCard();


}
