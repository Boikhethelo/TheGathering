package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Fast Lands: Enter untapped only if you control two or fewer other lands (e.g., Concealed Courtyard). Great for aggressive decks. */

public class FastLands extends AbstractLand {

    public FastLands(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
