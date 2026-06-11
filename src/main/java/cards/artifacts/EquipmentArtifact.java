package cards.artifacts;

import engine.GameState;

/**Attaches to creatures and gives them bonuses.*/
public class EquipmentArtifact extends AbstractArtifact{

    public EquipmentArtifact(String name , String description){
        super(name , description);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME

    }
}
