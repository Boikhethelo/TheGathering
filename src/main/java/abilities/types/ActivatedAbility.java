package abilities.types;

import abilities.Ability;
import costs.Cost;
import cards.Card;
import engine.GameState;

/**
 * An activated ability is explicitly activated by a player by paying its cost.
 * The format is always: {@code [Cost]: [Effect]}.
 *
 * Examples:
 * <ul>
 *   <li>"{T}: Add {G}."     — basic mana ability (see {@link ManaAbility})</li>
 *   <li>"{2}{B}: Destroy target creature."</li>
 *   <li>"{T}, Pay 2 life: Draw a card."</li>
 * </ul>
 *
 * Activated abilities use the stack (except mana abilities — see {@link ManaAbility}).
 * A player can activate any number of activated abilities during a turn as long
 * as they have priority and can pay the cost.
 */
public interface ActivatedAbility extends Ability {

    /**
     * The cost that must be paid to activate this ability.
     * Costs may be composite (e.g. tap + pay mana + pay life).
     */
    Cost cost();

    /**
     * Returns true if the current game state allows this ability to be activated.
     * This should check: correct zone, cost payable, targeting legality, etc.
     *
     * @param game   current game state
     * @param source the card that is the source of this ability
     */
    boolean canActivate(GameState game, Card source);

    /**
     * Activates this ability: pays the cost and places the effect on the stack.
     * {@link #canActivate} should be checked first.
     *
     * @param game   current game state (mutable)
     * @param source the card that is the source of this ability
     */
    void activate(GameState game, Card source);
}