package abilities;

/**
 * Root interface for all Magic: The Gathering card abilities.
 *
 * Every ability in the game is one of four concrete subtypes:
 *
 * <ul>
 *   <li>{@link abilities.types.StaticAbility}   — always-on effects ("Creatures you control get +1/+1")</li>
 *   <li>{@link abilities.types.TriggeredAbility} — fire on game events ("When ~ enters the battlefield…")</li>
 *   <li>{@link abilities.types.ActivatedAbility} — paid on demand ("{T}: Add {G}")</li>
 *   <li>{@link abilities.types.ManaAbility}     — activated abilities that produce mana (special: skip the stack)</li>
 * </ul>
 *
 * Keyword abilities (Flying, Trample, etc.) are modelled as the enum
 * {@link abilities.keyword.Keyword}, which implements {@link abilities.types.StaticAbility}.
 */
public interface Ability {
    /** Display name of the ability (e.g. "Flying", "Lifelink", "Draw a card"). */
    String abilityName();

    /** Human-readable rules description. */
    String description();
}