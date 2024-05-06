package org.uno.cards;

import org.uno.game.Game;

public class ChangeColorAndDrawFourEffect implements WildCardEffect {

    static  private final ChangeColorAndDrawFourEffect CHANGE_COLOR_AND_DRAW_FOUR_EFFECT=new ChangeColorAndDrawFourEffect();
    private ChangeColorAndDrawFourEffect()
    {

    }

    public static ChangeColorAndDrawFourEffect getChangeColorAndDrawFourEffect() {
        return CHANGE_COLOR_AND_DRAW_FOUR_EFFECT;
    }

    @Override
    public void preformEffect(Game game) {
        ChangeColorEffect.getWildEffect().preformEffect(game);
        DrawTwoCardEffect.getDrawTwoEffect().preformEffect(game);
        DrawTwoCardEffect.getDrawTwoEffect().preformEffect(game);
    }
    @Override
    public String toString()
    {
        return "Change Color With Draw Four Effect";
    }

}
