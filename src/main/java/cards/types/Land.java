package cards.types;

import cards.Card;
import model.Mana;

import java.util.EnumSet;

public interface Land extends Card {
    Mana tap(Mana colour);
    void untap();
    EnumSet<Mana> availableMana();
}
