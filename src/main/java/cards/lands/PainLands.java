package cards.lands;

import cards.Mana;

import java.util.ArrayList;

/** Pain Lands: Enter untapped, but deal 1 damage to you whenever you tap them for colored mana (e.g., Shivan Reef) */

public class PainLands extends Basic{

    public PainLands(String name , String description , ArrayList<Mana> mana){
            super(name , description , mana);
        }

        @Override
    public void placeCard(){
        ///Fix
    }
}
