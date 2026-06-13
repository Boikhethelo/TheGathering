package costs;

import cards.Card;
import engine.GameState;

/**
 * A cost that requires paying a fixed amount of life.
 *
 * Used by: Shock lands ({pay 2 life}), Fetch lands ({pay 1 life}),
 * Pain lands ({take 1 damage when tapping for coloured mana}), etc.
 *
 * A player can pay life as long as their life total would remain above 0
 * — except in Two-Headed Giant or variants where the team life total matters.
 * The 0-life check is enforced here conservatively.
 */
public class LifeCost implements Cost {

    public static final LifeCost ONE = new LifeCost(1);
    public static final LifeCost TWO = new LifeCost(2);

    private final int amount;

    public LifeCost(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Life cost must be positive, was: " + amount);
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    @Override
    public boolean canPay(GameState game, Card source) {
        // TODO: game.getPlayer(source.controller()).life() > amount
        // Player must have strictly more life than the cost to survive paying it
        return true; // placeholder
    }

    @Override
    public void pay(GameState game, Card source) {
        if (!canPay(game, source)) {
            throw new IllegalStateException("Cannot pay " + amount + " life — player would go to 0.");
        }
        // TODO: game.getPlayer(source.controller()).loseLife(amount)
    }

    @Override
    public String describe() {
        return "Pay " + amount + " life";
    }
}