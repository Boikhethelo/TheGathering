package cards.lands;

import model.Mana;
import cards.Status;
import engine.GameState;

import java.util.Collection;
import java.util.EnumSet;

public abstract class AbstractLand implements ILand{
    private final EnumSet<Mana> mana;
    private final String name;
    private final String description;
    protected Status status;

    public AbstractLand(String name , String description, Collection<Mana> mana){
        this.name = name;
        this.description = description;
        this.mana = mana.isEmpty() ? EnumSet.noneOf(Mana.class) : EnumSet.copyOf(mana);
        this.status = Status.UNTAPPED;

    }
    @Override
    public String name(){
        return name;
    }

    @Override
    public String description(){

        return description;
    }

    @Override
    public Status status(){
        return status;
    }


    @Override
    public Mana tap(Mana colour){
        if(!mana.contains(colour)){
            throw new IllegalArgumentException(name + " cannot produce " + colour + " mana. Available: " + mana);
        }
        this.status = Status.TAPPED;
        return colour;
    }

    @Override
    public void untap(){
        this.status = Status.UNTAPPED;
    }

    @Override
    public EnumSet<Mana> availableMana(){
        return mana;
    }

    public abstract void placeCard(GameState game);


}
