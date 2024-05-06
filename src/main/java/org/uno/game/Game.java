package org.uno.game;

import org.uno.cards.Card;
import org.uno.cards.CardValidator;

import java.util.ArrayList;
import java.util.List;

public abstract class Game implements PlayObserver {
    private final List<Player> players;
    private  Deck deck;
    private Card discardedCard ;
    private final CircularIterator circularIterator;

    public Game()
    {
        circularIterator = new CircularIterator(2);
        players = new ArrayList<>();
        Player playerOne = new Player("Player one",this);
        Player playerTwo = new Player("Player two",this);
        players.add(playerOne);
        players.add(playerTwo);
    }
    public void play()
    { 
        setupDeck();
        setupDiscardedCard();
        dealtCards();
        startGame();
    }

    protected void setupDeck()
    {
       deck = new Deck.DeckBuilder().buildStandardDeck().build();
    }

    protected void setupDiscardedCard()
    {
        discardedCard=deck.popCard();
    }

    protected abstract void dealtCards();

    public void discardCard(Card discardedCard)
    {
        this.discardedCard = discardedCard;
        getCurrentPlayer().removeFromHand(discardedCard);
        discardedCard.getCardEffect().preformEffect(this);
    }

    public Card getDiscardedCard()
    {
        return discardedCard;
    }

    private void startGame()
    {
        for (int i = 0;; circularIterator.next()) {
            performDiscard();
        }
    }
    public Player getCurrentPlayer()
    {
        return players.get(circularIterator.getCurrentPlayer());
    }

    protected void printTopPileCard()
    {
        System.out.println("Top Discard Pile Card : "+getDiscardedCard());
    }

    protected abstract void preformPenalty();
    protected abstract void performDiscard();

    @Override
    public void update(Card playedCard) {
        if(! CardValidator.isValid(discardedCard, playedCard)) {
            preformPenalty();
        }
        else{
           discardCard(playedCard);
        }
    }
    public void drawCard()
    {
        Card cardFromDeck = deck.popCard();
        getCurrentPlayer().addToHand(cardFromDeck);
    }


    public CircularIterator getCircularIterator() {
        return circularIterator;
    }
}

