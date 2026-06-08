package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/**Fetch lands don't actually tap for mana themselves. Instead, you pay 1 life, tap them, and sacrifice them to search your deck for a land with a specific basic land type and put it directly onto the battlefield (e.g., Polluted Delta). Because they can search for Shock Lands or True Duals, they are considered some of the best lands in the game for color-fixing.*/

public class FetchLands extends AbstractLand {

    public FetchLands(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
