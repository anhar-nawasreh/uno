package org.uno;

import org.uno.game.Game;

public class GameDriver {

    public static void main(String[] args) {

        Game game=new ClassicGame();
        game.play();
    }

}