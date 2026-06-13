package abilities.types;

import abilities.Ability;
import cards.Card;
import engine.GameState;

/**
 * A static ability is always active while the card is in the appropriate zone
 * (usually the battlefield). It has no trigger and no activation cost.
 *
 * Examples:
 * <ul>
 *   <li>Flying, Trample, Deathtouch — combat-layer keywords</li>
 *   <li>"Creatures you control have hexproof."</li>
 *   <li>"Your maximum hand size is seven."</li>
 * </ul>
 *
 * The engine queries a card's static abilities and applies them when
 * evaluating state (e.g. during combat, during damage assignment).
 */
public interface StaticAbility extends Ability {

    /**
     * Apply this ability's continuous effect to the game state.
     * Called by the engine's layer-based continuous-effect system,
     * not by individual cards.
     *
     * @param game   current game state
     * @param source the card that is the source of this ability
     */
    void apply(GameState game, Card source);
}