package cards.lands;

import cards.card;
import model.Mana;

import java.util.EnumSet;

public interface ILand extends card {
    Mana tap(Mana colour);
    void untap();
    EnumSet<Mana> availableMana();
}
