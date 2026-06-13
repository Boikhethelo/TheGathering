package events;

import cards.Card;

/**
 * Represents a discrete game event that triggered abilities can respond to.
 *
 * The engine fires a {@code GameEvent} whenever a rules-relevant state
 * change occurs. Every registered {@link abilities.types.TriggeredAbility}
 * is asked whether it {@code triggers()} on the event.
 *
 * Keep events coarse-grained at first — it is easier to add detail to an
 * event later than to split events after triggers have been written against them.
 */
public interface GameEvent {

    /** The category of event that occurred. */
    EventType type();

    /**
     * The card or object that is the primary subject of the event.
     * For ENTERS_BATTLEFIELD this is the card that entered.
     * For CREATURE_ATTACKS this is the attacking creature.
     */
    Card subject();

    // ── Standard factory ───────────────────────────────────────────────────

    static GameEvent of(EventType type, Card subject) {
        return new GameEvent() {
            @Override public EventType type()    { return type; }
            @Override public Card subject()      { return subject; }
            @Override public String toString()   { return type + "[" + subject.name() + "]"; }
        };
    }

    // ── Event taxonomy ─────────────────────────────────────────────────────

    enum EventType {

        // ── Zone changes ──────────────────────────────────────────────────
        ENTERS_BATTLEFIELD,    // permanent enters the battlefield
        LEAVES_BATTLEFIELD,    // permanent leaves the battlefield (any zone)
        DIES,                  // permanent moves from battlefield to graveyard
        EXILED,                // permanent or card is exiled
        DRAWN,                 // card drawn from library

        // ── Combat ────────────────────────────────────────────────────────
        CREATURE_ATTACKS,      // creature is declared as attacker
        CREATURE_BLOCKS,       // creature is declared as blocker
        COMBAT_DAMAGE_DEALT,   // combat damage step resolves
        PLAYER_ATTACKED,       // a player is attacked (no blockers)

        // ── Spells / abilities ────────────────────────────────────────────
        SPELL_CAST,            // any spell cast (any type)
        CREATURE_SPELL_CAST,   // specifically a creature spell
        NONCREATURE_SPELL_CAST,// noncreature spell — triggers Prowess
        ABILITY_ACTIVATED,     // any activated ability activated

        // ── Turn structure ────────────────────────────────────────────────
        UPKEEP_BEGIN,          // beginning of upkeep step
        DRAW_STEP_BEGIN,       // draw step begins
        MAIN_PHASE_BEGIN,      // pre-combat main phase begins
        COMBAT_BEGIN,          // beginning of combat step
        END_STEP_BEGIN,        // end step begins
        TURN_BEGIN,            // very start of a player's turn

        // ── Life / damage ─────────────────────────────────────────────────
        LIFE_GAINED,           // a player gains life
        LIFE_LOST,             // a player loses life
        DAMAGE_DEALT,          // any damage dealt

        // ── Counters ──────────────────────────────────────────────────────
        COUNTER_PLACED,        // a counter is put on a permanent or player
        COUNTER_REMOVED,       // a counter is removed

        // ── Lands ─────────────────────────────────────────────────────────
        LAND_PLAYED,           // a land is played (not cast — special action)
    }
}