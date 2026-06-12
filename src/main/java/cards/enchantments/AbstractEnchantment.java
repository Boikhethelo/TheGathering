package cards.enchantments;

import cards.Status;
import cards.types.Enchantment;
import engine.GameState;
import model.Mana;

import java.util.Collections;
import java.util.Map;

public abstract class AbstractEnchantment implements Enchantment {
    private final String name;
    private final String description;
    private final Map<Mana,Integer> tapRequirement;
    private Status status;

    public AbstractEnchantment(String name , String description , Map<Mana,Integer> tapRequirement){
        this.name = name;
        this.description = description;
        this.tapRequirement = tapRequirement;
        this.status = Status.DEACTIVATE;

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
    public Map<Mana,Integer> tapRequirement(){
        return Collections.unmodifiableMap(tapRequirement);
    }

    public abstract void placeCard(GameState game);

}
