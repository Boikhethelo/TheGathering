package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/**These lands tap for mana like normal, but you can pay a specific mana cost to temporarily turn them into a creature until the end of the turn. They are excellent for dodging "board wipe" spells (which destroy all creatures) since they revert back to being normal lands when your turn ends. Mutavault and Celestial Colonnade are classic examples.*/

public class CreatureLand extends AbstractLand {

    public CreatureLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana );

    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
