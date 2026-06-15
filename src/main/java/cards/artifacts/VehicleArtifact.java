package cards.artifacts;

import engine.GameState;

/**Can become a creature when "crewed."*/

public class VehicleArtifact extends AbstractArtifact {
    public VehicleArtifact(String name, String description){
        super(name, description);
    }

    @Override
    public void placeCard(GameState game){
        ///TODO:
    }
}
