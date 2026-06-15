package cards.artifacts;

import abilities.types.ActivatedAbility;
import cards.Card;
import costs.Cost;
import costs.ManaCost;
import costs.SacrificeCost;
import engine.GameState;

/**Attaches to creatures and gives them bonuses.*/
public class EquipmentArtifact extends AbstractArtifact implements ActivatedAbility {

    public EquipmentArtifact(String name , String description){
        super(name , description);
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
    public Cost cost(){
        return new ManaCost(null);
    }

    @Override
    public boolean canActivate(GameState game , Card source){
        ///FIXME
        return true;
    }

    @Override
    public void activate(GameState game, Card source){
        ///FIXME
    }


}
