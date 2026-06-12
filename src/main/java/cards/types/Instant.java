package cards.types;

import cards.Card;
import model.Mana;

import java.util.Map;

public interface Instant extends Card {
    Map<Mana,Integer> requirement();
}
