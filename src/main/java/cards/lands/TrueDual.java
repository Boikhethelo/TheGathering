package cards.lands;

import cards.Mana;
import cards.Status;

import java.util.ArrayList;

/**True Duals: The original lands from MTG's first sets (e.g., Underground Sea). They have no drawbacks, making them incredibly powerful and expensive. */

public class TrueDual extends Basic{


    public TrueDual(String name , String description , ArrayList<Mana> mana){
        super(name , description , mana );
    }

@Override
public void placeCard(){

        this.status = Status.UNTAPPED;

}

}
