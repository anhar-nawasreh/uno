package org.uno.cards;

import org.uno.game.Game;

public class DrawTwoCardEffect implements ActionCardEffect {

    static final private DrawTwoCardEffect DRAW_TWO_EFFECT=new DrawTwoCardEffect();
    private DrawTwoCardEffect()
    {

    }

    public static DrawTwoCardEffect getDrawTwoEffect() {
        return DRAW_TWO_EFFECT;
    }

    @Override
    public void preformEffect(Game game) {
        game.getCircularIterator().next();
        game.drawCard();
        game.drawCard();
        game.getCircularIterator().previous();
    }


    @Override
    public String toString()
    {
        return "Draw Two";
    }

}
