package cards.artifacts;

import engine.GameState;

public class BasicArtifact extends AbstractArtifact{
    public BasicArtifact(String name , String description){
        super(name , description);
    }

    @Override
    public void placeCard(GameState game){
        ///FIXME Should parse decription and assign ability eg. Sol Ring read its description and add mana to player pool
    }
}
