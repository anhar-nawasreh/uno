package org.uno.cards;

public class WildValidator extends CardValidator{


    private final ColorsSet colorToChange;
    WildValidator(ColorsSet colorToChange)
    {
        this.colorToChange=colorToChange;
    }

    @Override
    protected boolean specificCardValidation(Card pileCard, Card playedCard) {
        if(colorToChange == null) return true;
        return colorToChange.colorEquals(playedCard.getCardColor());
    }

    @Override
    public String toString() {
        return  "wild cards validator";
    }
}
