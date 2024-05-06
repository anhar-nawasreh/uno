package org.uno.game;

import org.uno.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hand {
    private final List<Card> cards;

    Hand()
    {
        cards=new ArrayList<>();
    }

    void addToHand(Card drawnCard)
    {
        cards.add(drawnCard);
    }

    public Card getCard(int cardIndex) {
        return cards.get(cardIndex-1);
    }
    void discardCard(Card discardedCard)
    {
        cards.remove(discardedCard);
    }

    int getHandCardsNumber()
    {
        return cards.size();
    }
    void printHandCards()
    {
        IntStream.range(0, getHandCardsNumber())
                .forEach(i -> System.out.printf("%d- %s%n", i+1, cards.get(i)));
    }

    @Override
    public String toString() {
        return cards.stream().map(Card::toString).collect(Collectors.joining(", "));
    }
}
