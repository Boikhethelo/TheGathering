package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/**Convert one type of mana into two of another colour.*/
public class FilterLand extends AbstractLand {

    public FilterLand(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
