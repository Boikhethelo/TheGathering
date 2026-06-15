package cards.creature;

import engine.GameState;
import model.Mana;

import java.util.Map;

public class ShapeshifterCreature extends AbstractCreature{
    public ShapeshifterCreature(String name, String description , String type, Map<Mana, Integer> requirement, int defense , int attack){
        super(name, description, type , requirement, defense , attack);
    }

    @Override
    public void placeCard(GameState game){
        ///TODO:
    }
}
