package org.uno.cards;

import org.uno.game.Game;

import java.util.Scanner;

public class ChangeColorEffect implements WildCardEffect{

    private static final ChangeColorEffect CHANGE_COLOR_EFFECT =new ChangeColorEffect();
    private String colorToChange;
    private ChangeColorEffect()
    {

    }

    public static ChangeColorEffect getWildEffect() {
        return CHANGE_COLOR_EFFECT;
    }

    @Override
    public void preformEffect(Game game) {
       ColorsSet playerColor = getPlayerColor();
       CardValidator.addCardValidator(game.getDiscardedCard(),new WildValidator(playerColor));
    }
    private ColorsSet getPlayerColor() {
        askPlayerForColor();
        validatePlayerColor();
        return StandardColor.valueOf(colorToChange.toUpperCase());
    }

    private void askPlayerForColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a color for the Wild card: ");
        colorToChange=scanner.nextLine().toUpperCase();
    }

    private void validatePlayerColor() {
        try {
            StandardColor.valueOf(colorToChange.toUpperCase());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Your entered color is not part from cards color set ");
            getPlayerColor();
        }
    }

    @Override
    public String toString()
    {
        return "Change Color Effect";
    }
}
