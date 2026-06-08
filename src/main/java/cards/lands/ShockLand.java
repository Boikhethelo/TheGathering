package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/**Shock Lands: Enter the battlefield tapped unless you pay 2 life (e.g., Blood Crypt). They also have basic land types (like "Swamp Mountain"), meaning they can be easily searched for.*/

public class ShockLand extends AbstractLand {

    public ShockLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME

    }
}
