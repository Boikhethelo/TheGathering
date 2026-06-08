package cards;

import engine.GameState;

public interface card {
    String name();
    String description();
    Status status();
    void placeCard(GameState game);
}
