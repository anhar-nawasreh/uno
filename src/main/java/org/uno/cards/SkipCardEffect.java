package org.uno.cards;

import org.uno.game.Game;

public class SkipCardEffect implements ActionCardEffect {
    final static private SkipCardEffect SKIP_CARD_EFFECT=new SkipCardEffect();

    private SkipCardEffect()
    {

    }

    public static SkipCardEffect getSkipCardEffect() {
        return SKIP_CARD_EFFECT;
    }

    @Override
    public void preformEffect(Game game) {
        game.getCircularIterator().next();
    }

    @Override
    public String toString() {
        return "Skip Effect";
    }
}
