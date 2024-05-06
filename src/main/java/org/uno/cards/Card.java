package org.uno.cards;

import java.util.Objects;

final public class Card {
    private final CardType cardType;
    private final CardEffectStrategy cardEffect;
    private final ColorsSet cardColor;

    final static public class CardsFactory {
        private CardsFactory(){

        }
        public static Card createNumberedCardOf(NumericCard cardNumber, ColorsSet cardColor)
        {
            return new Card(cardNumber,cardColor,NullEffect.getNullEffect());
        }

        public static Card createWildCardOf(WildCardEffect changeEffect)
        {
            return new Card(SpecialCards.WILD,StandardColor.COLOR_FULL, changeEffect);
        }

        public static Card createActionCardOf(ActionCardEffect actionCardEffect, ColorsSet cardColor)
        {
            return new Card(SpecialCards.ACTION,cardColor, actionCardEffect);
        }
        public static Card customizeActionCardOf( CardEffectStrategy cardEffect ,ColorsSet cardColor )
        {
            return new Card(SpecialCards.ACTION,cardColor,cardEffect);
        }
        public static Card customizeWildCardOf( CardEffectStrategy cardEffect )
        {
            return new Card(SpecialCards.WILD,StandardColor.COLOR_FULL,cardEffect);
        }
    }

    private Card( CardType cardType, ColorsSet cardColor, CardEffectStrategy cardEffect)
    {
        this.cardType=cardType;
        this.cardColor=cardColor;
        this.cardEffect=cardEffect;
    }

    public ColorsSet getCardColor()
    {
        return cardColor;
    }
    public CardType getCardType()
    {
        return cardType;
    }

    public CardEffectStrategy getCardEffect()
    {
        return cardEffect;
    }
    @Override
    public boolean equals(Object object) {
        if ( this == object ) return true;
        if ( object == null || getClass() != object.getClass() ) return false;
        Card card = (Card) object;
        return Objects.equals(cardType, card.cardType) && Objects.equals(cardEffect, card.cardEffect) && Objects.equals(cardColor, card.cardColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardEffect, cardColor);
    }

    @Override
    public String toString() {

        return cardType+" "+cardColor+" Card "+((cardEffect instanceof  NullEffect)?"":"( "+cardEffect+" )");
    }
}

