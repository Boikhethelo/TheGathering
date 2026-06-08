package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/** Scryland/Temple Enter tapped, but let you Scry 1. Very widely played. */
public class ScryLand extends AbstractLand {

    public ScryLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
