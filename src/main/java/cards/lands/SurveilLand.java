package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/**  Enter tapped, but let you Surveil 1. Mechanically similar to Scry Lands but worth separating.*/
public class SurveilLand extends AbstractLand {
    public SurveilLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
