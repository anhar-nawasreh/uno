package org.uno.cards;

final public class ColorCardsValidator extends CardValidator{

    static final private ColorCardsValidator COLOR_CARDS_VALIDATOR=new ColorCardsValidator();

    private ColorCardsValidator(){

    }

    public static ColorCardsValidator getColorCardsValidator() {
        return COLOR_CARDS_VALIDATOR;
    }

    @Override
    public boolean specificCardValidation(Card pileCard, Card playedCard) {
        ColorsSet pileCardColor = pileCard.getCardColor();
        ColorsSet playedCardColor = playedCard.getCardColor();
        return pileCardColor.colorEquals(playedCardColor);
    }

    @Override
    public String toString() {
        return "color card validator";
    }
}
