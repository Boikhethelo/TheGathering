package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Slow Lands: The opposite of Fast Lands—they enter untapped only if you control two or more other lands.*/

public class SlowLands extends AbstractLand {

    public SlowLands(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
