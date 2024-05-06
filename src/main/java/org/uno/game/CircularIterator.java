package org.uno.game;

public class CircularIterator {
        private  boolean isReverseMode=false;
        private  int currentPlayer=0;
        private  int playersNumber;
        CircularIterator( int playersNumber )
        {
            this.playersNumber = playersNumber;
        }
        public void next() {
            if (isReverseMode) {
                reverseMode();
            }
            else{
                forwardMode();
            }
        }
        public void previous() {
            if ( isReverseMode ) {
                forwardMode();
            } else {
                reverseMode();
            }
        }

        private void forwardMode ()
        {
        currentPlayer = (currentPlayer + 1) % playersNumber;
        }

        private void reverseMode ()
        {
            currentPlayer = (currentPlayer -1 + playersNumber) % playersNumber;

        }

        public void switchMode()
        {
        isReverseMode = !isReverseMode;
        }

        public int getCurrentPlayer()
        {
            return currentPlayer;
        }

        public int getPlayersNumber() {
            return playersNumber;
        }
}