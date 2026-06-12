package cards.enchantments;

import engine.GameState;
import model.Mana;

import java.util.Map;

public class AuraEnchantment extends AbstractEnchantment {
    public AuraEnchantment(String name , String description , Map<Mana,Integer> tapRequirement ){
        super(name, description, tapRequirement);

    }


    @Override
    public void placeCard(GameState game){
        ///FIXME
    }
}

/**Aura: The most common subtype. Auras don't just sit on the field; they must be attached to another permanent (like a creature or land) or a player. If that permanent leaves the battlefield, the Aura goes to the graveyard.  */
