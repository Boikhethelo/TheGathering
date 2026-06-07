package cards.lands;

import cards.Mana;

import java.util.ArrayList;

/**Shock Lands: Enter the battlefield tapped unless you pay 2 life (e.g., Blood Crypt). They also have basic land types (like "Swamp Mountain"), meaning they can be easily searched for.*/

public class ShockLand extends Basic{

    public ShockLand(String name , String description , ArrayList<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(){
        ///FIXME

    }
}
