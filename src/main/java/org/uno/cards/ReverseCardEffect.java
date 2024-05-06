package org.uno.cards;

import org.uno.game.Game;

public class ReverseCardEffect implements ActionCardEffect {
    private static final ReverseCardEffect REVERSE_CARD_EFFECT=new ReverseCardEffect();

    private ReverseCardEffect()
    {

    }

    public static ReverseCardEffect getReverseCardEffect() {
        return REVERSE_CARD_EFFECT;
    }

    @Override
    public void preformEffect(Game game) {
        if ( game.getCircularIterator().getPlayersNumber() == 2 )
             SkipCardEffect.getSkipCardEffect().preformEffect(game);
        else
            game.getCircularIterator().switchMode();
    }

    @Override
    public String toString() {
        return "Reverse Effect";
    }
}
