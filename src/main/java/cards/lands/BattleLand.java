package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Battle / Tango Lands (e.g., Canopy Vista) — Enter untapped only if you control two or more basic lands (distinct from Slow Lands, which count any other lands). */
public class BattleLand extends AbstractLand {
    public BattleLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }

}
