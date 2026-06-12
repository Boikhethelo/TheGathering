package cards.types;

import cards.Card;
import model.Mana;

import java.util.Map;

public interface Enchantment extends Card {
    Map<Mana,Integer> tapRequirement();

}
