package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/**  Enter untapped if you control a basic land of a specific type. One of the most common dual land cycles.*/

public class CheckLand extends AbstractLand {
    public CheckLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
