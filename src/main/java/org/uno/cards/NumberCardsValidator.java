package org.uno.cards;

final public class NumberCardsValidator extends CardValidator{
    static final private NumberCardsValidator NUMBER_CARDS_VALIDATOR=new NumberCardsValidator();

    public static NumberCardsValidator getNumberCardsValidator()
    {
        return NUMBER_CARDS_VALIDATOR;
    }

    private NumberCardsValidator()
    {

    }
    public boolean specificCardValidation(Card pileCard, Card playedCard) {

        CardType pileCardType=pileCard.getCardType();
        CardType playedCardType=playedCard.getCardType();
        return playedCardType.equals(pileCardType) ||
                ColorCardsValidator.getColorCardsValidator().specificCardValidation(pileCard,playedCard);
    }

    @Override
    public String toString() {
        return "numbers card validator";
    }
}
