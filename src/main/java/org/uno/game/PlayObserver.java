package org.uno.game;

import org.uno.cards.Card;

public interface PlayObserver {
    void update(Card playedCard); // update means update the game state after playing
}
