package cards.lands;

import model.Mana;
import cards.Status;
import engine.GameState;

import java.util.Collection;

/**
 * True Duals — the original dual lands from MTG's first sets (e.g., Underground Sea).
 * No entry restriction, no life payment, no damage. Simply enter untapped.
 */
public class TrueDual extends AbstractLand {

    public TrueDual(String name, String description, Collection<Mana> mana) {
        super(name, description, mana);
    }

    @Override
    public void placeCard(GameState game) {
        setStatus(Status.UNTAPPED); // no drawback — enter untapped unconditionally
    }
}