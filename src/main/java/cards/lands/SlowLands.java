package cards.lands;

import cards.Mana;

import java.util.ArrayList;

/** Slow Lands: The opposite of Fast Lands—they enter untapped only if you control two or more other lands.*/

public class SlowLands extends Basic {

    public SlowLands(String name , String description , ArrayList<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(){
        ///FIX
    }
}
