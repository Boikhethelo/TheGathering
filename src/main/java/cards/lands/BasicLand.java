package cards.lands;

import model.Mana;
import engine.GameState;
import cards.Status;

import java.util.Collection;

/**
 * Basic lands — Plains, Island, Swamp, Mountain, Forest (and Wastes).
 * You may run any number of copies. They enter the battlefield UNTAPPED
 * and tap for one specific colour of mana.
 */
public class BasicLand extends AbstractLand {

    public BasicLand(String name, String description, Collection<Mana> mana) {
        super(name, description, mana);
    }

    /**
     * Basic lands enter the battlefield untapped — no restriction.
     * The constructor already sets UNTAPPED as the default, so this
     * method makes the intent explicit rather than being a silent no-op.
     */
    @Override
    public void placeCard(GameState game) {
        setStatus(Status.UNTAPPED);
    }
}