package cards.types;

import cards.Card;

public interface Artifact extends Card {
    void activate();
    void deactivate();
}
