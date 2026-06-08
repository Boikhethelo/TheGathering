package cards.lands;

import cards.Mana;

import java.util.ArrayList;

/**Instead of fixing your colors, utility lands offer spell-like abilities. They usually only tap for colorless mana, meaning you can't put too many in your deck without ruining your colors.

 Example: Reliquary Tower taps for colorless mana, but its static ability means you have no maximum hand size.

 Example: Field of Ruin can be sacrificed to destroy an opponent's powerful non-basic land.*/

public class UtilityLand extends Basic {

    public UtilityLand(String name , String description , ArrayList<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(){
        ///FIXME
    }
}
