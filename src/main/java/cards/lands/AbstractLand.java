package cards.lands;

import cards.types.Land;
import model.Mana;
import cards.Status;
import engine.GameState;

import java.util.Collection;
import java.util.EnumSet;

public abstract class AbstractLand implements Land {

    private final EnumSet<Mana> mana;
    private final String name;
    private final String description;

    // Private — subclasses must use setStatus() to set ETB state.
    // This ensures tap() / untap() remain the authoritative state machine
    // and the tapped-state guard cannot be bypassed by a subclass assignment.
    private Status status;

    public AbstractLand(String name, String description, Collection<Mana> mana) {
        this.name   = name;
        this.description = description;
        this.mana   = mana.isEmpty() ? EnumSet.noneOf(Mana.class) : EnumSet.copyOf(mana);
        this.status = Status.UNTAPPED;
    }

    // ── Protected ETB helper ───────────────────────────────────────────────
    // Subclasses call this inside placeCard() to declare their entry state.
    // Using a named helper rather than direct field access makes the intent
    // explicit and keeps the field private.
    protected void setStatus(Status status) {
        this.status = status;
    }

    // ── Card interface ─────────────────────────────────────────────────────
    @Override public String name()        { return name; }
    @Override public String description() { return description; }
    @Override public Status status()      { return status; }

    // ── Land interface ─────────────────────────────────────────────────────

    /**
     * Taps this land to produce one mana of the requested colour.
     *
     * @throws IllegalStateException  if the land is already tapped
     * @throws IllegalArgumentException if this land cannot produce the requested colour
     */
    @Override
    public Mana tap(Mana colour) {
        if (status == Status.TAPPED) {
            throw new IllegalStateException(name + " is already tapped.");
        }
        if (!mana.contains(colour)) {
            throw new IllegalArgumentException(
                    name + " cannot produce " + colour + " mana. Available: " + mana);
        }
        this.status = Status.TAPPED;
        return colour;
    }

    @Override
    public void untap() {
        this.status = Status.UNTAPPED;
    }

    @Override
    public EnumSet<Mana> availableMana() {
        return EnumSet.copyOf(mana); // defensive copy
    }

    public abstract void placeCard(GameState game);
}
