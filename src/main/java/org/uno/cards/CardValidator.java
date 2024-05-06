package org.uno.cards;

import java.util.HashMap;
import java.util.Map;

public abstract class CardValidator  {
     static final private Map<Card,CardValidator> CARDS_VALIDATOR_REPOSITORY =new HashMap<>();

     protected abstract boolean specificCardValidation(Card pileCard, Card playedCard);
     public static boolean isValid(Card pileCard, Card playedCard){
          return CARDS_VALIDATOR_REPOSITORY.get(pileCard).specificCardValidation(pileCard,playedCard);
     }

     public static void addCardValidator(Card card, CardValidator cardValidator)
     {
         CARDS_VALIDATOR_REPOSITORY.put(card,cardValidator);
     }


}
