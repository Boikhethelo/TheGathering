package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Bounce Lands / Karoo Lands (e.g., Dimir Aqueduct) — Enter and return a land you control to your hand, but tap for two mana. Unique ETB mechanic.*/
public class BounceLand extends AbstractLand {
    public BounceLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
