package cards.enchantments;

import abilities.types.StaticAbility;
import cards.Card;
import engine.GameState;
import model.Mana;

import java.util.Map;

/**A special legendary enchantment type used in Commander. If your commander has the "Choose a Background" ability, you can start the game with a Background enchantment in your command zone as a second commander.*/
public class BackgroundEnchantment extends AbstractEnchantment implements StaticAbility {
    public BackgroundEnchantment(String name , String description , Map<Mana,Integer> requirement){
        super(name, description,requirement);
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
