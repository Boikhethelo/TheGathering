package cards.lands;

import cards.Mana;
import cards.Status;

import java.util.ArrayList;

/**Basic lands are the foundation of MTG. You can have any number of Basic Lands in your deck, bypassing the standard rule that limits you to four copies of a single card. Each taps for one specific color of mana.*/

public class Land extends Basic{

    public Land(String name , String description , ArrayList<Mana> mana){
        super(name, description , mana);
    }

    @Override
    public void placeCard(){
        this.status = Status.TAPPED;
    }
}
