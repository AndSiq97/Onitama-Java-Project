package main;

// TODO: Add Javadoc comments for this class and all its methods. (Task 6.1)
public class Player {

    protected final char player;

    public Player(char player) {
        this.player = player;
    }

    public Turn getTurn() {
        return null;
    }

    public char getPlayer() {
        return player;
    }
}