package cards.lands;

import model.Mana;
import cards.Status;
import engine.GameState;

import java.util.Collection;

/** Taplands / Guildgates: The most basic non-basics. They enter the battlefield tapped, meaning you have to wait a turn to use them, but they have no other downside.*/

public class Taplands extends AbstractLand {

    public Taplands(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        this.status = Status.TAPPED;
    }
}
