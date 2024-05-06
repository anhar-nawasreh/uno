package org.uno.cards;

import java.util.Arrays;

public enum StandardColor implements ColorsSet {
    RED, BLUE, YELLOW, GREEN, COLOR_FULL;
    @Override
    public boolean colorEquals(ColorsSet otherColor)
    {
        if ( this == otherColor )
            return true;
        return otherColor == COLOR_FULL || this == COLOR_FULL;
    }
    public static StandardColor[] standardColorsValues()
    {
        return new StandardColor[]{RED, BLUE, YELLOW, GREEN};
    }

}
