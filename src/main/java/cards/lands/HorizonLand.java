package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Can be sacrificed to draw a card at the cost of 1 life. Distinct enough from utility lands to warrant their own class.*/
public class HorizonLand extends AbstractLand {

    public HorizonLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);

    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
