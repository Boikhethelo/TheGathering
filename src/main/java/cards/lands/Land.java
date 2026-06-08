package cards.lands;

import model.Mana;
import cards.Status;
import engine.GameState;

import java.util.Collection;

/**Basic lands are the foundation of MTG. You can have any number of Basic Lands in your deck, bypassing the standard rule that limits you to four copies of a single card. Each taps for one specific color of mana.*/

public class Land extends AbstractLand {

    public Land(String name , String description , Collection<Mana> mana){
        super(name, description , mana);
    }

    @Override
    public void placeCard(GameState game){
        this.status = Status.TAPPED;
    }
}
