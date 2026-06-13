package abilities.keyword;

import abilities.types.StaticAbility;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Every keyword ability defined in the MTG comprehensive rules.
 *
 * Keywords are singleton static abilities — their rules meaning is fixed
 * by the rules document, so an enum is the natural model:
 * <ul>
 *   <li>No heap allocation per card — all cards sharing Flying share the same constant.</li>
 *   <li>Implements {@link StaticAbility} so it integrates with the ability system.</li>
 * </ul>
 *
 * Add new keywords here as they become relevant to the engine.
 */
public enum Keyword implements StaticAbility {

    // ── Evasion ───────────────────────────────────────────────────────────
    FLYING          ("Flying",          "Can only be blocked by creatures with flying or reach."),
    REACH           ("Reach",           "Can block creatures with flying."),
    MENACE          ("Menace",          "Can only be blocked by two or more creatures."),
    SHADOW          ("Shadow",          "Can only block or be blocked by creatures with shadow."),
    FEAR            ("Fear",            "Can only be blocked by artifact creatures or black creatures."),
    INTIMIDATE      ("Intimidate",      "Can only be blocked by artifact creatures or creatures that share a colour."),
    HORSEMANSHIP    ("Horsemanship",    "Can only be blocked by creatures with horsemanship."),

    // ── Combat damage modifiers ───────────────────────────────────────────
    TRAMPLE         ("Trample",         "Excess damage is dealt to the defending player or planeswalker."),
    FIRST_STRIKE    ("First Strike",    "Deals combat damage before creatures without first strike."),
    DOUBLE_STRIKE   ("Double Strike",   "Deals both first-strike and regular combat damage."),
    DEATHTOUCH      ("Deathtouch",      "Any amount of damage this deals is enough to destroy."),
    LIFELINK        ("Lifelink",        "Damage dealt also causes its controller to gain that much life."),
    INFECT          ("Infect",          "Deals damage to creatures as -1/-1 counters and to players as poison counters."),
    WITHER          ("Wither",          "Deals damage to creatures as -1/-1 counters."),
    POISONOUS       ("Poisonous",       "Dealing combat damage gives the opponent poison counters."),

    // ── Timing / placement ────────────────────────────────────────────────
    HASTE           ("Haste",           "Can attack and use tap abilities the turn it enters the battlefield."),
    FLASH           ("Flash",           "Can be cast any time you could cast an instant."),
    VIGILANCE       ("Vigilance",       "Attacking does not cause this creature to tap."),
    DEFENDER        ("Defender",        "Cannot attack."),

    // ── Protection ────────────────────────────────────────────────────────
    HEXPROOF        ("Hexproof",        "Cannot be the target of spells or abilities opponents control."),
    SHROUD          ("Shroud",          "Cannot be the target of any spells or abilities."),
    PROTECTION      ("Protection",      "Cannot be blocked, targeted, dealt damage, enchanted, or equipped by sources of the specified quality."),
    INDESTRUCTIBLE  ("Indestructible",  "Cannot be destroyed by damage or effects that say 'destroy'."),
    WARD            ("Ward",            "When targeted by an opponent's spell or ability, that player must pay the ward cost or the spell/ability is countered."),

    // ── Triggered keyword actions ─────────────────────────────────────────
    PROWESS         ("Prowess",         "Gets +1/+1 until end of turn whenever you cast a noncreature spell."),
    TRAINING        ("Training",        "When this attacks alongside a creature with greater power, put a +1/+1 counter on this."),
    UNDYING         ("Undying",         "When this dies without a +1/+1 counter, return it with a +1/+1 counter."),
    PERSIST         ("Persist",         "When this dies without a -1/-1 counter, return it with a -1/-1 counter."),
    UNEARTH        ("Unearth",         "Pay the unearth cost: return this from your graveyard to the battlefield until end of turn."),

    // ── Activated keyword abilities ───────────────────────────────────────
    EQUIP           ("Equip",           "Pay the equip cost to attach this equipment to a creature you control."),
    FORTIFY         ("Fortify",         "Pay the fortify cost to attach this fortification to a land you control."),
    CREW            ("Crew",            "Tap creatures with total power N to turn this into an artifact creature until end of turn."),
    CYCLING         ("Cycling",         "Pay the cycling cost and discard this card to draw a card."),
    KICKER          ("Kicker",          "Pay the kicker cost when casting this spell to get an additional effect."),
    OVERLOAD        ("Overload",        "Pay the overload cost to affect all valid targets instead of one."),
    REPLICATE       ("Replicate",       "Pay the replicate cost when casting to copy the spell."),
    SPLICE          ("Splice",          "Pay the splice cost when casting another spell of the specified type to add this spell's effects."),

    // ── ETB / leave triggers ──────────────────────────────────────────────
    LANDFALL        ("Landfall",        "Triggers whenever a land enters the battlefield under your control."),
    RAID            ("Raid",            "Provides a bonus if you attacked this turn."),
    EXPLORE         ("Explore",         "Reveal the top card of library; if it's a land, put it in hand, otherwise put a +1/+1 counter on this."),

    // ── Graveyard mechanics ───────────────────────────────────────────────
    FLASHBACK       ("Flashback",       "Can be cast from your graveyard for its flashback cost, then exiled."),
    ESCAPE          ("Escape",          "Can be cast from your graveyard by paying its escape cost and exiling other cards."),
    EMBALM          ("Embalm",          "Pay the embalm cost and exile this from your graveyard to create a white Zombie token copy."),
    ETERNALIZE      ("Eternalize",      "Pay the eternalize cost and exile this from your graveyard to create a 4/4 black Zombie token copy."),
    AFTERMATH       ("Aftermath",       "The second half of a split card, castable only from the graveyard."),

    // ── Counters ──────────────────────────────────────────────────────────
    PROLIFERATE     ("Proliferate",     "Choose any number of permanents and/or players with counters, then add one more of any counter already there."),
    MODULAR         ("Modular",         "Enters with +1/+1 counters. When it dies, move its counters to an artifact creature."),

    // ── Misc ──────────────────────────────────────────────────────────────
    CONVOKE         ("Convoke",         "Your creatures can help cast this spell, each tapping to pay for {1} or one mana of its colour."),
    DELVE          ("Delve",           "Each card you exile from your graveyard while casting this spell pays for {1}."),
    IMPROVISE       ("Improvise",       "Your artifacts can help cast this spell, each tapping to pay for {1}."),
    AFFINITY        ("Affinity",        "This spell costs {1} less to cast for each artifact you control."),
    STORM           ("Storm",           "When you cast this spell, copy it for each spell cast before it this turn."),
    SPLIT_SECOND    ("Split Second",    "While this spell is on the stack, players can't cast spells or activate nonmana abilities."),
    SUSPEND         ("Suspend",         "Pay the suspend cost and exile this with time counters; cast it for free when the last counter is removed."),
    CASCADE         ("Cascade",         "When you cast this, exile cards until you hit a cheaper nonland card and cast it for free."),
    REBOUND         ("Rebound",         "Instead of putting this into your graveyard as it resolves, exile it; cast it again for free on your next upkeep.");

    // ─────────────────────────────────────────────────────────────────────
    private final String name;
    private final String description;

    Keyword(String name, String description) {
        this.name        = name;
        this.description = description;
    }

    @Override
    public String abilityName(){
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    // ── GameState application ─────────────────────────────────────────────
    // Keyword static abilities are enforced by the combat / resolution engine,
    // not by calling apply() individually. The apply() method is a hook for
    // the engine to query "does this card have X?" rather than imperative logic.
    @Override
    public void apply(engine.GameState game, cards.Card source) {
        // Enforcement is done by the engine rules layer, not here.
        // e.g. CombatResolver checks source.abilities().contains(Keyword.FLYING)
    }

    // ── DB parsing ────────────────────────────────────────────────────────

    /**
     * Converts the MTGJSON {@code keywords} column (comma-separated, e.g.
     * {@code "Flying, Trample, Haste"}) into a set of {@link Keyword} constants.
     *
     * Unrecognised keywords are silently skipped — this allows the DB to
     * contain newer keywords without crashing.
     *
     * @param keywordsStr the raw DB string, may be null or empty
     * @return an EnumSet of matched keywords; never null, may be empty
     */
    public static Set<Keyword> parse(String keywordsStr) {

        if (keywordsStr == null || keywordsStr.isBlank()) return EnumSet.noneOf(Keyword.class);

        return Arrays.stream(keywordsStr.split(","))
                .map(String::trim)
                .map(k -> k.toUpperCase().replace(" ", "_").replace("-", "_"))
                .flatMap(k -> {
                    try {
                        return java.util.stream.Stream.of(Keyword.valueOf(k));
                    } catch (IllegalArgumentException e) {
                        return java.util.stream.Stream.empty(); // unknown keyword — skip
                    }
                })
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Keyword.class)));
    }


}