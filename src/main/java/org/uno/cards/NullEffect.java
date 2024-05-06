package org.uno.cards;

import org.uno.game.Game;

public class NullEffect implements CardEffectStrategy{

    final private static NullEffect NULL_EFFECT=new NullEffect();

    private NullEffect()
    {

    }

    public static NullEffect getNullEffect() {
        return NULL_EFFECT;
    }

    @Override
    public void preformEffect(Game game) {

    }
    @Override
    public String toString()
    {
        return "";
    }

}
