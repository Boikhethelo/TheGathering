package cards.enchantments;

import abilities.types.StaticAbility;
import cards.Card;
import engine.GameState;
import model.Mana;

import java.util.Map;

public class AuraEnchantment extends AbstractEnchantment implements StaticAbility {
    public AuraEnchantment(String name , String description , Map<Mana,Integer> requirement ){
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

    //===============
    // StaticAbility
    //===============

    @Override
    public void apply(GameState game, Card source){
        ///TODO
    }

}

/**Aura: The most common subtype. Auras don't just sit on the field; they must be attached to another permanent (like a creature or land) or a player. If that permanent leaves the battlefield, the Aura goes to the graveyard.  */
