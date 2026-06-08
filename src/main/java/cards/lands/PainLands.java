package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Pain Lands: Enter untapped, but deal 1 damage to you whenever you tap them for colored mana (e.g., Shivan Reef) */

public class PainLands extends AbstractLand {

    public PainLands(String name , String description , Collection<Mana> mana){
            super(name , description , mana);
        }

        @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
