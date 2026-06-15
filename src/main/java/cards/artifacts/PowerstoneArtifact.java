package cards.artifacts;

import abilities.types.TriggeredAbility;
import cards.Card;
import costs.Cost;
import costs.ManaCost;
import engine.GameState;
import events.GameEvent;

/**Produces colorless mana with restrictions.*/

public class PowerstoneArtifact extends AbstractArtifact implements TriggeredAbility {
    public PowerstoneArtifact(String name , String description){
        super(name, description);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME

    }

    //=======================================
    //            Ability
    //=======================================

    @Override
    public String abilityName(){
        return "";
    }

    @Override
    public String description(){
        return "";
    }

    //=========================================
    //            ActivatedAbility
    //=========================================


    @Override
    public boolean triggers(GameEvent event, GameState game){
        ///TODO
        return true;
    }

    @Override
    public void resolve(GameState game, Card source){
        ///TODO
    }

}
