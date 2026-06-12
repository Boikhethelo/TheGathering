package cards.sorcery;

import cards.Status;
import cards.types.Sorcery;
import engine.GameState;
import model.Mana;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractSorcery implements Sorcery {
    private final String name;
    private final String description;
    private Map<Mana,Integer> requirement;
    private Status status;

    public AbstractSorcery(String name , String description , Map<Mana,Integer> requirement){
        this.name = name;
        this.description = description;
        this.requirement = new HashMap<Mana, Integer>(requirement);
        this.status = Status.ALIVE;
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
    public Map<Mana,Integer> requirement(){
        return Collections.unmodifiableMap(requirement);
    }

    public abstract void placeCard(GameState game);

}
