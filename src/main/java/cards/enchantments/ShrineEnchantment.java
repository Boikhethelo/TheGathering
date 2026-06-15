package cards.enchantments;

import abilities.types.TriggeredAbility;
import cards.Card;
import engine.GameState;
import events.GameEvent;
import model.Mana;

import java.util.Map;

/**A legendary subtype where the cards scale in power. The more Shrines you control on the battlefield simultaneously, the more powerful each individual Shrine's triggered effect becomes.*/
public class ShrineEnchantment extends AbstractEnchantment implements TriggeredAbility {
    public ShrineEnchantment(String name , String description, Map<Mana,Integer> requirement){
        super( name , description , requirement);
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
