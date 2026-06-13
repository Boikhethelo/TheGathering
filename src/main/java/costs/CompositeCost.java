package costs;

import cards.Card;
import engine.GameState;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Combines two or more costs that must all be paid simultaneously.
 *
 * Examples:
 * <ul>
 *   <li>Fetch land: {@code TapCost + LifeCost(1) + SacrificeCost}</li>
 *   <li>Shock land ETB: {@code LifeCost(2)} or entering tapped</li>
 *   <li>Pain land: {@code TapCost} — damage is a side-effect of the mana ability, not part of the cost</li>
 *   <li>Horizon land: {@code TapCost + LifeCost(1) + SacrificeCost}</li>
 * </ul>
 *
 * All component costs are checked before any are paid (atomicity).
 */
public class CompositeCost implements Cost {

    private final List<Cost> costs;

    public CompositeCost(Cost... costs) {
        this.costs = List.of(costs);
    }

    public List<Cost> components() {
        return costs;
    }

    /**
     * Returns true only if ALL component costs can be paid.
     * No cost is paid until all pass — prevents partial payment.
     */
    @Override
    public boolean canPay(GameState game, Card source) {
        return costs.stream().allMatch(c -> c.canPay(game, source));
    }

    /**
     * Pays all component costs in order.
     * The order matters: e.g. tap before spending mana mirrors actual MTG rules.
     */
    @Override
    public void pay(GameState game, Card source) {
        if (!canPay(game, source)) {
            throw new IllegalStateException("Cannot pay composite cost: " + describe());
        }
        costs.forEach(c -> c.pay(game, source));
    }

    @Override
    public String describe() {
        return costs.stream()
                .map(Cost::describe)
                .collect(Collectors.joining(", "));
    }

    // ── Factory helpers ────────────────────────────────────────────────────

    /** The classic land tap cost: "{T}: Add mana." */
    public static CompositeCost tap() {
        return new CompositeCost(TapCost.INSTANCE);
    }

    /** Tap + pay life (e.g. Fetch land activation). */
    public static CompositeCost tapAndLife(int lifeAmount) {
        return new CompositeCost(TapCost.INSTANCE, new LifeCost(lifeAmount));
    }
}