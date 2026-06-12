package cards.instants;

import cards.creature.BasicCreature;
import engine.GameState;
import model.Mana;

import java.util.Map;

public class BasicInstant extends AbstractInstant{
    public BasicInstant(String name , String description , Map<Mana,Integer> requirement){
        super(name,description,requirement);

    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
