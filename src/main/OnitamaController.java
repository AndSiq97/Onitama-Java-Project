package main;

/**
 * An abstract superclass to represent an Onitama Controller between any two Players.
 * Each Player will take turns making a move during the Onitama game play.
 * The OnitamaController is a parent class of the other three subclasses:
 * 1. OnitamaControllerHumanVSHuman
 * 2. OnitamaControllerHumanVSRandom
 * 3. OnitamaControllerRandomVSRandom
 * This is due to Polymorphism that Onitama controller can take on any
 * of these three types of controllers depending on the type of Player.
 */

public class OnitamaController {

    protected Onitama onitama;

    /**
     * Plays the Onitama game.
     */
    public void play() {
        while (onitama.getWinner() == OnitamaBoard.EMPTY) {
            this.report();

            Turn turn = null;
            Player whosTurn = onitama.getWhoseTurn();
            turn = whosTurn.getTurn();

            this.reportTurn(whosTurn.getPlayer(), turn);
            onitama.move(turn.getRowO(), turn.getColO(), turn.getRowD(),
                    turn.getColD(), turn.getStyle());
        }
        this.reportFinal();
    }

    /**
     * Reports the player that makes a valid move
     * on their turn during the the Onitama game.
     */
    public void reportTurn(char whosTurn, Turn turn) {

        System.out.println(whosTurn + " makes move " + turn + "\n");
    }

    /**
     * Reports the current state of the Onitama Board
     * and both players' available styles (and style with no owner).
     * Also reports player on who's turn it is to make the next move.
     */
     public void report() {

        String s = onitama.getBoardString() + onitama.getStylesString(OnitamaBoard.G1) +
                onitama.getStylesString(OnitamaBoard.G2) +
                onitama.getStylesString(OnitamaBoard.EMPTY)
                + "  " + onitama.getWhoseTurn().getPlayer() + " moves next";
        System.out.println(s);
    }

    /**
     * Reports the player that won the Onitama game
     * and the final state of the Onitama Board.
     */
    public void reportFinal() {

        String s = onitama.getBoardString() + "  "
                + onitama.getWinner() + " won\n";
        System.out.println(s);
    }
}
