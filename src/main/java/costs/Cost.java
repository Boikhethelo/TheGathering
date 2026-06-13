package costs;

import cards.Card;
import engine.GameState;

/**
 * Represents the cost that must be paid to activate an ability or cast a spell.
 *
 * MTG costs are not always mana — they can be:
 * <ul>
 *   <li>Mana       — {@link ManaCost}</li>
 *   <li>Tapping    — {@link TapCost}</li>
 *   <li>Life       — {@link LifeCost}</li>
 *   <li>Sacrifice  — {@link SacrificeCost} (not yet implemented)</li>
 *   <li>Discard    — {@link DiscardCost} (not yet implemented)</li>
 *   <li>Combination — {@link CompositeCost} (e.g. "{T}, Pay 2 life")</li>
 * </ul>
 *
 * The {@link CompositeCost} handles the common case of paying multiple costs
 * simultaneously (e.g. tapping AND paying mana).
 */
public interface Cost {

    /**
     * Returns true if the controller of {@code source} can currently pay this cost
     * given the game state. Does NOT pay the cost.
     *
     * @param game   current game state
     * @param source the card whose ability is being activated
     */
    boolean canPay(GameState game, Card source);

    /**
     * Pays this cost, mutating the game state accordingly.
     * Should only be called after {@link #canPay} returns true.
     *
     * @param game   current game state (mutable)
     * @param source the card whose ability is being activated
     * @throws IllegalStateException if the cost cannot be paid
     */
    void pay(GameState game, Card source);

    /** Human-readable cost description (e.g. "{T}", "{2}{W}", "Pay 2 life"). */
    String describe();
}