package cards.lands;

import cards.Mana;

import java.util.ArrayList;

/** Fast Lands: Enter untapped only if you control two or fewer other lands (e.g., Concealed Courtyard). Great for aggressive decks. */

public class FastLands extends Basic {

    public FastLands(String name , String description , ArrayList<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(){
        ///FIXME
    }
}
