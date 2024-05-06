package org.uno.game;

import org.uno.cards.Card;

public interface PlayEventSubject {
    void notifyGame(Card playedCard); // will modify the game in case of the player play a card

}
