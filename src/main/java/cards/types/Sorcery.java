package cards.types;

import cards.Card;
import model.Mana;

import java.util.Map;

public interface Sorcery extends Card {
    Map<Mana,Integer> requirement();

}
