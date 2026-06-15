package cards.enchantments;

import abilities.types.ActivatedAbility;
import cards.Card;
import costs.Cost;
import costs.ManaCost;
import engine.GameState;
import model.Mana;

import java.util.Map;

/**Class: Inspired by D&D, these allow you to spend mana like a sorcery to "level up" the enchantment, unlocking new persistent abilities at Level 2 and Level 3 while keeping the perks of the previous levels.  */
public class ClassEnchantment extends AbstractEnchantment implements ActivatedAbility {
    public ClassEnchantment(String name , String description , Map<Mana,Integer> requirement){
        super(name, description , requirement);
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

    //=================
    //ActivatedAbility
    //=================

    @Override
    public Cost cost(){
        return new ManaCost(null);
    }


    @Override
    public boolean canActivate(GameState game, Card source){
        ///TODO:
        return true;
    }

    @Override
    public void activate(GameState game, Card source){
        ///TODO:
    }


}
