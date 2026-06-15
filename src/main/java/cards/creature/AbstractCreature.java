package cards.creature;

import cards.Status;
import cards.types.Creature;
import engine.GameState;
import model.Mana;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCreature implements Creature {
    private String name;
    private String description;
    private String type;
    private Map<Mana, Integer> tapRequirement;
    private final int defense;
    private final int attack;
    private Status status;

    public AbstractCreature(String name , String description , String type , Map<Mana, Integer> requirement , int defense , int attack){
        this.name = name;
        this.description = description;
        this.type = type;
        this.tapRequirement = new HashMap<Mana,Integer>(requirement);
        this.defense = defense;
        this.attack = attack;
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
    public String type(){
        return type;
    }

    @Override
    public int defense(){
        return defense;
    }

    @Override
    public int attack(){
        return attack;
    }

    @Override
    public Map<Mana,Integer> tapRequirement(){
        return Collections.unmodifiableMap(tapRequirement);
    }

    public abstract void placeCard(GameState game);
}
