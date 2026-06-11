package cards.artifacts;

import cards.Status;
import cards.types.Artifact;
import engine.GameState;

public abstract class AbstractArtifact implements Artifact {
    private final String name;
    private final String description;
    private Status status;

    public AbstractArtifact(String name , String description){
        this.name = name;
        this.description = description;
    }

    @Override
    public String name(){
        return name;
    }

    @Override
    public String description(){
        return description;
    }

    @Override
    public Status status(){
        return status;
    }

    @Override
    public void activate(){
        this.status = Status.ACTIVATED;
    }

    @Override
    public void deactivate(){
        this.status = Status.DEACTIVATE;
    }

    @Override
    public abstract void placeCard(GameState game);

}
