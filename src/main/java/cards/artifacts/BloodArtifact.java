package cards.artifacts;

import abilities.types.ActivatedAbility;
import cards.Card;
import costs.DiscardCost;
import costs.SacrificeCost;
import costs.Cost;
import engine.GameState;

/**Discard a card and sacrifice it to draw a card.*/
public class BloodArtifact extends AbstractArtifact implements ActivatedAbility , DiscardCost {

    public BloodArtifact(String name , String description){
        super(name , description);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME Should trigger the sacrifice and draw a card
    }

    //=======================================
    //            Ability
    //=======================================

    @Override
    public String abilityName(){
        return "Blood Sacrifice";
    }

    @Override
    public String description(){
        return "Discard a card and draw a new card";
    }

    //=========================================
    //            ActivatedAbility
    //=========================================


    @Override
    public Cost cost(){
        return new SacrificeCost();
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

    //=========================================
    //              DiscardCost
    //=========================================

    @Override
    public void discardCard(GameState game){
        ///TODO: Must discard the card to graveyard after activated
    }




}
