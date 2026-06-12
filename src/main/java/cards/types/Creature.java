package cards.types;

import cards.Card;
import model.Mana;

import java.util.Map;

public interface Creature extends Card {
    String type();
    int defense();
    int attack();
    Map<Mana,Integer> tapRequirement();

}
