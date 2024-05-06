package org.uno.game;

import org.uno.cards.Card;
import org.uno.exceptions.InvalidInputRangeException;

import java.util.Scanner;

public class Player implements PlayEventSubject {

    private final PlayObserver playEventObserver;
    private final Hand hand;
    private int enteredCardSymbol;
    private final  PlayerInputManager playerInputManager= new PlayerInputManager();
    private final String playerName;

    private class PlayerInputManager {
        private static final Scanner playerConsoleScanner=new Scanner(System.in);
        private void checkPlayerInput() {
            try {
                validatePlayerInput();
            } catch (InvalidInputRangeException e) {
                System.out.println(e.getMessage());
                choiceCard();
            }
        }

        private void validatePlayerInput() throws InvalidInputRangeException {
            if ( enteredCardSymbol < 0 || enteredCardSymbol > hand.getHandCardsNumber() )
                throw new InvalidInputRangeException(enteredCardSymbol + " is out of range card option");
        }

        private void takePlayerInput() {
            System.out.println("Enter associated number with the card you want to play , "+playerName);
            enteredCardSymbol = playerConsoleScanner.nextInt();
        }
    }

    public Player(String playerName,Game game) {
        playEventObserver = game;
        this.playerName = playerName;
        hand=new Hand();
    }

    public void play() {
        hand.printHandCards();
        choiceCard();
        notifyGame(hand.getCard(enteredCardSymbol));
        isWinner();

    }

    private void choiceCard() {
        playerInputManager.takePlayerInput();
        playerInputManager.checkPlayerInput();
    }

    @Override
    public void notifyGame(Card playedCard) {
        playEventObserver.update(playedCard);
    }

    private void isWinner() {
        if ( hand.getHandCardsNumber() == 0)
        {
            printWinnerCongrats();
            System.exit(0);
        }
    }

    private void printWinnerCongrats()
    {
        System.out.println("WE HAVE A WINNER \n"+"CONGREGATION "+playerName);
    }

    public void addToHand(Card card) {
        hand.addToHand(card);
    }

    public void removeFromHand(Card discardedCard) {
        hand.discardCard(discardedCard);
    }
}
