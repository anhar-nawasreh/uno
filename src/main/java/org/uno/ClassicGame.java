package org.uno;

import org.uno.cards.Card;
import org.uno.cards.SkipCardEffect;
import org.uno.game.Deck;
import org.uno.game.Game;
import org.uno.game.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassicGame extends Game {
    private final static int DEALT_CARDS_NUMBER=7;
    public ClassicGame() {

    }

    @Override
    protected void dealtCards() {

        for (int i = 0; i <getCircularIterator().getPlayersNumber() ; i++) {
            for (int j = 1; j <= DEALT_CARDS_NUMBER; j++) {
                drawCard();
            }
            getCircularIterator().next();
        }
    }

    @Override
    protected void preformPenalty() {
        System.out.println("You will get your penalty");
        drawCard();
        System.out.println("One card has added to your hand");
    }

    @Override
    protected void performDiscard() {
        printTopPileCard();
        getCurrentPlayer().play();

    }

}
