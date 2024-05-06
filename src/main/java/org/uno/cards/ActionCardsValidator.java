package org.uno.cards;

final public class ActionCardsValidator extends CardValidator{

    final static private ActionCardsValidator ACTION_CARDS_VALIDATOR=new ActionCardsValidator();

    private ActionCardsValidator()
    {

    }
    static public ActionCardsValidator getActionCardsValidator()
    {
        return ACTION_CARDS_VALIDATOR;
    }
    @Override
    public boolean specificCardValidation(Card pileCard, Card playedCard) {


        return  pileCard.getCardEffect() == playedCard.getCardEffect( ) ||
                ColorCardsValidator.getColorCardsValidator().specificCardValidation(pileCard, playedCard);
    }

    @Override
    public String toString() {
        return "action card validator";
    }
}
