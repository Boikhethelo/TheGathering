package costs;

import cards.Card;
import engine.GameState;

public class SacrificeCost implements Cost{

    private Card sacrifice;

    public SacrificeCost(){

    }

    @Override
    public boolean canPay(GameState game , Card source){
        // TODO: query game.getCards(source.controller()).canPay(requirement)
        return true;
    }

    @Override
    public void pay(GameState game, Card source){
        ///TODO: Remove sacrifice from game
    }

    @Override
    public String describe(){
        return "";
    }
}
