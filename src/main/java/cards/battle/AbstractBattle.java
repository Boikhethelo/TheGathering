package cards.battle;

import cards.Card;
import cards.Status;
import cards.types.Battle;
import engine.GameState;

public abstract class AbstractBattle implements Battle {
    private final String name;
    private final String description;
    protected Status status;
    private final Card protector;

    public AbstractBattle(String name , String description , Card protector){
        this.name = name;
        this.description = description;
        this.status = Status.ALIVE;
        this.protector = protector;
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
    public Card protector(){
        return protector;
    }

    public abstract void placeCard(GameState game);

}
