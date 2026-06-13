package costs;

import cards.Card;
import engine.GameState;
import model.Mana;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * A cost that requires paying specific amounts of mana.
 *
 * Stored as a {@code Map<Mana, Integer>} — e.g. {@code {WHITE=1, COLORLESS=2}}
 * represents "{1}{W}".
 *
 * Factory constants cover the most common single-mana costs to avoid
 * allocating new maps for every land or basic spell.
 */
public class ManaCost implements Cost {

    public static final ManaCost FREE  = new ManaCost(Map.of());
    public static final ManaCost ONE   = new ManaCost(Map.of(Mana.COLORLESS, 1));
    public static final ManaCost TWO   = new ManaCost(Map.of(Mana.COLORLESS, 2));
    public static final ManaCost W     = new ManaCost(Map.of(Mana.WHITE,     1));
    public static final ManaCost U     = new ManaCost(Map.of(Mana.BLUE,      1));
    public static final ManaCost B     = new ManaCost(Map.of(Mana.BLACK,     1));
    public static final ManaCost R     = new ManaCost(Map.of(Mana.RED,       1));
    public static final ManaCost G     = new ManaCost(Map.of(Mana.GREEN,     1));

    private final Map<Mana, Integer> requirement;

    public ManaCost(Map<Mana, Integer> requirement) {
        this.requirement = Collections.unmodifiableMap(new EnumMap<>(requirement));
    }

    public Map<Mana, Integer> requirement() {
        return requirement;
    }

    @Override
    public boolean canPay(GameState game, Card source) {
        // TODO: query game.getManaPool(source.controller()).canPay(requirement)
        return true; // placeholder until ManaPool is wired into GameState
    }

    @Override
    public void pay(GameState game, Card source) {
        // TODO: game.getManaPool(source.controller()).spend(requirement)
    }

    @Override
    public String describe() {
        if (requirement.isEmpty()) return "{0}";
        StringBuilder sb = new StringBuilder();
        int generic = requirement.getOrDefault(Mana.COLORLESS, 0);
        if (generic > 0) sb.append("{").append(generic).append("}");
        for (Mana m : new Mana[]{Mana.WHITE, Mana.BLUE, Mana.BLACK, Mana.RED, Mana.GREEN}) {
            int count = requirement.getOrDefault(m, 0);
            String symbol = switch (m) {
                case WHITE     -> "W";
                case BLUE      -> "U";
                case BLACK     -> "B";
                case RED       -> "R";
                case GREEN     -> "G";
                case COLORLESS -> "C";
            };
            for (int i = 0; i < count; i++) sb.append("{").append(symbol).append("}");
        }
        return sb.toString();
    }
}