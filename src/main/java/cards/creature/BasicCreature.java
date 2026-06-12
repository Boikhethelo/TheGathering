package cards.creature;

import engine.GameState;
import model.Mana;

import java.util.Map;

public class BasicCreature extends AbstractCreature {

    public BasicCreature(String name , String description , String type , Map<Mana,Integer> tapRequirement , int defense , int attack){
        super(name, description, type , tapRequirement, defense , attack);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
