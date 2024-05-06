package org.uno.cards;

import org.uno.game.Deck;

public interface CardDeckConfiguration {

    Deck.DeckBuilder customizeDeck(Deck.DeckBuilder deckBuilder);
}


