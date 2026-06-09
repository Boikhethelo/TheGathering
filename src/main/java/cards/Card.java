package cards;

import engine.GameState;

public interface Card {
    String name();
    String description();
    Status status();
    void placeCard(GameState game);
}
