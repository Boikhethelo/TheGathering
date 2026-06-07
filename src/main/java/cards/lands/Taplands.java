package cards.lands;

import cards.Mana;
import cards.Status;

import java.util.ArrayList;

/** Taplands / Guildgates: The most basic non-basics. They enter the battlefield tapped, meaning you have to wait a turn to use them, but they have no other downside.*/

public class Taplands extends Basic{

    public Taplands(String name , String description , ArrayList<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(){
        this.status = Status.TAPPED;
    }
}
