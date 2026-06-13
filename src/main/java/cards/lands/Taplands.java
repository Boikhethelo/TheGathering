package cards.lands;

import model.Mana;
import cards.Status;
import engine.GameState;

import java.util.Collection;

/**
 * Taplands / Guildgates — the most basic non-basics.
 * They enter the battlefield tapped, so you have to wait a turn to use
 * them, but they have no other downside.
 */
public class Taplands extends AbstractLand {

    public Taplands(String name, String description, Collection<Mana> mana) {
        super(name, description, mana);
    }

    @Override
    public void placeCard(GameState game) {
        setStatus(Status.TAPPED); // always enters tapped — no condition
    }
}