package cards.artifacts;

import abilities.Ability;
import cards.Status;
import cards.types.Artifact;
import engine.GameState;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArtifact implements Artifact {
    private final String name;
    private final String description;
    private Status status;
    protected List<Ability> abilityList;


    public AbstractArtifact(String name , String description){
        this.name = name;
        this.description = description;
        this.status = Status.DRAWN;
        this.abilityList = new ArrayList<>();

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
    public String ability(){
        return "";
    }


    @Override
    public abstract void placeCard(GameState game);

}
