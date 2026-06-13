package costs;

import cards.Card;
import cards.Status;
import engine.GameState;

/**
 * The "{T}" cost — tapping the source permanent.
 *
 * This is the most common activation cost in the game. Every land's mana
 * ability uses it, as do most equipment abilities, utility lands, etc.
 *
 * Singleton — only one instance is ever needed.
 */
public final class TapCost implements Cost {

    public static final TapCost INSTANCE = new TapCost();

    private TapCost() {}

    @Override
    public boolean canPay(GameState game, Card source) {
        // Can pay if the source is currently untapped.
        // Creatures with summoning sickness also cannot tap — that check
        // belongs in the engine's activation validator, not here.
        return source.status() == Status.UNTAPPED;
    }

    @Override
    public void pay(GameState game, Card source) {
        if (!canPay(game, source)) {
            throw new IllegalStateException(source.name() + " is already tapped — cannot pay tap cost.");
        }
        // The card's tap() method handles state mutation for lands.
        // For non-land permanents, GameState will need a general tap() call.
        // TODO: route through game.tap(source) once GameState is implemented.
    }

    @Override
    public String describe() {
        return "{T}";
    }
}