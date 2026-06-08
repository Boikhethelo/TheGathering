package cards.lands;

import model.Mana;
import cards.Status;
import engine.GameState;

import java.util.Collection;

/**True Duals: The original lands from MTG's first sets (e.g., Underground Sea). They have no drawbacks, making them incredibly powerful and expensive. */

public class TrueDual extends AbstractLand {


    public TrueDual(String name , String description , Collection<Mana> mana){
        super(name , description , mana );
    }

@Override
public void placeCard(GameState game){

        this.status = Status.UNTAPPED;

}

}
