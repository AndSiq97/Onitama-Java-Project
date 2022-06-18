package main;

/**
 * A subclass to represent an Onitama Controller between a Human Player and a
 * Random Player. Each Player will take turns making a move during the
 * Onitama game play.
 * The OnitamaControllerHumanVSRandom subclass is inherited from the OnitamaController
 * superclass.
 */

public class OnitamaControllerHumanVSRandom extends OnitamaController {

    PlayerHuman player1;
    PlayerRandom player2;

    /**
     * Constructs a new main.OnitamaControllerHumanVSRandom.
     * Sets up a new Onitama game between the Human Player
     * and a Random Player.
     */

    public OnitamaControllerHumanVSRandom() {
        super();
        this.player1 = new PlayerHuman(OnitamaBoard.G1);
        this.player2 = new PlayerRandom(OnitamaBoard.G2);
        this.onitama = new Onitama(player1, player2);
        this.player2.setOnitama(this.onitama);
    }

    /**
     * Main function which creates and runs main.OnitamaControllerHumanVSRandom.
     */

    public static void main(String[] args) {

        OnitamaControllerHumanVSRandom oc = new OnitamaControllerHumanVSRandom();
        oc.play();
    }
}
