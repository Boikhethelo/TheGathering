package abilities.types;

import model.Mana;
import cards.Card;
import engine.GameState;

import java.util.EnumSet;

/**
 * A mana ability is a special category of {@link ActivatedAbility} (or in rare
 * cases {@link TriggeredAbility}) that adds mana to a player's mana pool.
 *
 * MTG Comprehensive Rules §605: Mana abilities resolve immediately and do NOT
 * use the stack. This makes them distinct enough to warrant their own interface.
 *
 * Examples:
 * <ul>
 *   <li>"{T}: Add {G}."              — all basic land tap abilities</li>
 *   <li>"{T}: Add {W} or {U}."       — dual land tap abilities</li>
 *   <li>"Sacrifice this: Add {W}{U}{B}{R}{G}."  — Lotus Petal / Black Lotus</li>
 *   <li>"{T}: Add {C}{C}."           — Sol Ring / Mana Vault</li>
 * </ul>
 *
 * The engine resolves mana abilities immediately without passing priority
 * or putting anything on the stack.
 */
public interface ManaAbility extends ActivatedAbility {

    /**
     * The set of mana colours this ability can produce.
     * Used by the engine to populate the player's mana pool
     * and to check whether a mana cost can be paid.
     *
     * @param game   current game state (some abilities produce different mana
     *               depending on context, e.g. Cavern of Souls)
     * @param source the card that is the source of this ability
     * @return the colours of mana this activation produces; never null
     */
    EnumSet<Mana> producedMana(GameState game, Card source);
}