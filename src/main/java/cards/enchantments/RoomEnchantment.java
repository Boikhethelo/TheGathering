package cards.enchantments;


import abilities.types.TriggeredAbility;
import cards.Card;
import engine.GameState;
import events.GameEvent;
import model.Mana;

import java.util.Map;

/**Found on split-style double-enchantment cards. When you cast a Room, you pay the mana cost for one side to unlock it. While it's on the battlefield, you can pay the mana cost of the other side later to unlock that room as well.*/
public class RoomEnchantment extends AbstractEnchantment implements TriggeredAbility {
    public RoomEnchantment(String name , String description , Map<Mana, Integer> requirement){
        super(name, description, requirement);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }

    //=================
    //   Ability
    //=================
    @Override
    public String abilityName(){
        return "";
    }

    @Override
    public String description(){
        return "";
    }

    //====================
    // TriggeredAbility
    //====================

    @Override
    public boolean triggers(GameEvent event, GameState game){
        ///TODO:
        return true;
    }

    @Override
    public void resolve(GameState game, Card source){
        ///TODO
    }


}
