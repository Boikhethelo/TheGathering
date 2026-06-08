package cards.lands;

import model.Mana;
import engine.GameState;

import java.util.Collection;

/**These lands can tap for three different colors of mana. They almost always enter the battlefield tapped to balance out their immense flexibility. Many of them also feature "Cycling," allowing you to discard them to draw a card if you don't need the mana later in the game.*/

public class Triomes extends AbstractLand {

    public Triomes(String name , String description , Collection<Mana> mana){
        super(name , description , mana);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}
