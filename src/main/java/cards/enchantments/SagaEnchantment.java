package cards.enchantments;

import abilities.types.TriggeredAbility;
import cards.Card;
import engine.GameState;
import events.GameEvent;
import model.Mana;

import java.util.Map;

/**: These represent historical events. They enter the battlefield with a lore counter and gain another one after your draw step. Each counter triggers a specific chapter ability (Chapter I, II, III). Once the final chapter finishes, you sacrifice the Saga.*/
public class SagaEnchantment extends AbstractEnchantment implements TriggeredAbility {
    public SagaEnchantment(String name , String description, Map<Mana,Integer> requirement){
        super(name,description,requirement);
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
