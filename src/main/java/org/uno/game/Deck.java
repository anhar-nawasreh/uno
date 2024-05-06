package org.uno.game;

import org.uno.cards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;
    public static class DeckBuilder
    {
        private final static int NUMBER_OF_WILD_CARDS = 4;
        private final static int NUMBER_OF_ACTION_CARDS_EACH_COLOR=2;
        private  List<Card> cards;

        public DeckBuilder() {
           cards = new ArrayList<>();
        }

        public DeckBuilder buildStandardDeck()
        {
            buildFullNumberedCardsDeck();
            buildFullActionsCardsDeck();
            buildFullWildCardsDeck();
            return this;
        }
        public DeckBuilder buildCustomDeck(CardDeckConfiguration cardDeckConfiguration)
        {
            return cardDeckConfiguration.customizeDeck(this);

        }

        public DeckBuilder buildFullNumberedCardsDeck()
        {
            addAllColorNumberedCardsFrom(NumericCard.ZERO);
            addAllColorNumberedCardsFrom(NumericCard.ONE);
            return this;
        }

        private DeckBuilder addAllColorNumberedCardsFrom(NumericCard startingNumber) {
            for (ColorsSet color: StandardColor.standardColorsValues()) {
                addAllNumberedCardsFrom(startingNumber,color);
            }
            return this;
        }

        private DeckBuilder addAllNumberedCardsFrom(NumericCard startingNumber,ColorsSet color)
        {
            NumericCard [] numbers = NumericCard.values();
            for (int j = startingNumber.ordinal(); j <numbers.length; j++) {
                addNumberedCards(numbers[j],color);
            }
            return this;

        }

        public DeckBuilder buildFullActionsCardsDeck()
        {
            for (ColorsSet color : StandardColor.standardColorsValues()) {
                addSkipActionCards(NUMBER_OF_ACTION_CARDS_EACH_COLOR,color);
                addReverseActionCards(NUMBER_OF_ACTION_CARDS_EACH_COLOR,color);
                addDrawTwoActionCards(NUMBER_OF_ACTION_CARDS_EACH_COLOR,color);
            }
            return this;
        }

        public DeckBuilder addSkipActionCards(int cardsNumber, ColorsSet cardsColor) {
            validateNumberOfCards(cardsNumber);
            Card actionCard = Card.CardsFactory.createActionCardOf(SkipCardEffect.getSkipCardEffect(),cardsColor);
            for (int i = 0; i < cardsNumber; i++) {
                cards.add(actionCard);
            }
            CardValidator.addCardValidator(actionCard,ActionCardsValidator.getActionCardsValidator());
            return this;
        }
        public DeckBuilder addReverseActionCards(int cardsNumber, ColorsSet cardsColor) {
            validateNumberOfCards(cardsNumber);
            Card actionCard = Card.CardsFactory.createActionCardOf(ReverseCardEffect.getReverseCardEffect(),cardsColor);
            for (int i = 0; i < cardsNumber; i++) {
                cards.add(actionCard);
            }
            CardValidator.addCardValidator(actionCard,ActionCardsValidator.getActionCardsValidator());
            return this;
        }
        public DeckBuilder addDrawTwoActionCards(int cardsNumber, ColorsSet cardsColor) {
            validateNumberOfCards(cardsNumber);
            Card actionCard = Card.CardsFactory.createActionCardOf(DrawTwoCardEffect.getDrawTwoEffect(),cardsColor);
            for (int i = 0; i < cardsNumber; i++) {
                cards.add(actionCard);
            }
            CardValidator.addCardValidator(actionCard,ActionCardsValidator.getActionCardsValidator());
            return this;
        }
        public DeckBuilder buildFullWildCardsDeck() {
            addWildCards(NUMBER_OF_WILD_CARDS);
            addWildCardDrawFourActionCards(NUMBER_OF_WILD_CARDS);
            return this;

        }

        public DeckBuilder addWildCardDrawFourActionCards(int cardsNumber) {
            validateNumberOfCards(cardsNumber);
            Card wildCard = Card.CardsFactory.createWildCardOf(ChangeColorAndDrawFourEffect.getChangeColorAndDrawFourEffect());
            for (int j = 0; j <cardsNumber ; j++) {
                cards.add(wildCard);
            }
            return this;
        }

        public DeckBuilder addWildCards(int cardsNumber) {
            validateNumberOfCards(cardsNumber);
            Card wildCard = Card.CardsFactory.createWildCardOf(ChangeColorEffect.getWildEffect());
            for (int i = 0; i < cardsNumber; i++) {
                cards.add(wildCard);
            }
            return this;

        }
        private void validateNumberOfCards(int cardsNumber)
        {
            if ( cardsNumber <= 0 )
                throw new IllegalArgumentException("You use invalid number of cards");
        }

        public DeckBuilder addNumberedCards(NumericCard cardNumber, ColorsSet cardColor) {
            Card numberedCard = Card.CardsFactory.createNumberedCardOf(cardNumber,cardColor);
            CardValidator.addCardValidator(numberedCard,NumberCardsValidator.getNumberCardsValidator());
            cards.add(numberedCard);
            return this;

        }

        public DeckBuilder addCustomizeCards(int cardsNumber, Card customizedCard,CardValidator cardValidator) {
            validateNumberOfCards(cardsNumber);
            for (int i = 0; i < cardsNumber; i++) {
                cards.add(customizedCard);
            }
            CardValidator.addCardValidator(customizedCard,cardValidator);
            return this;

        }
        public Deck build()
        {
            return new Deck(this);
        }

    }

    private Deck(DeckBuilder builder)
    {
        this.cards = builder.cards;
        shuffleCards();
    }

    private void shuffleCards()
    {
        Collections.shuffle(cards);
    }

    public Card popCard() {
      return cards.remove(cards.size()-1);
    }
    public int deckSize()
    {
        return cards.size();
    }

    @Override
    public String toString() {
        return  cards.toString();
    }
}
