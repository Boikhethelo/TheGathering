package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Double-faced cards; you choose which side (and thus which colour) when you play them. Would require DFC support in your model. */
public class PathwayLand extends AbstractLand {

    public PathwayLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
