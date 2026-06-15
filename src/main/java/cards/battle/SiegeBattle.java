package cards.battle;

import abilities.types.TriggeredAbility;
import cards.Card;
import engine.GameState;
import events.GameEvent;

public class SiegeBattle extends AbstractBattle implements TriggeredAbility {

    public SiegeBattle(String name , String description , Card protector){
        super(name , description , protector);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME
    }

    //=========================
    //       Ability
    //=========================

    @Override
    public String abilityName(){
        return "Siege";
    }

    @Override
    public String description(){
        return "When you cast a Siege battle, it enters the battlefield horizontally. " +
                "You choose one of your opponents to be its \"protector.\"  " +
                "The Conflict: You (and any other players in a multiplayer game) can attack the battle with your creatures to try and defeat it. " +
                "The designated protector is the only one who can assign blockers to defend it.  The Reward: The battle enters with defense counters. " +
                "You can wear those counters down by attacking it or hitting it with spells that target \"any target.\" When the last defense counter is removed, the battle is defeated. " +
                "Its controller (you) exiles it and casts the back face of the card for free!";
    }

    //========================
    //   TriggeredAbility
    //========================

    @Override
    public boolean triggers(GameEvent event, GameState game){
        ///TODO:
        return true;
    }

    @Override
    public void resolve(GameState game, Card source){
        ///TODO:
    }
}


