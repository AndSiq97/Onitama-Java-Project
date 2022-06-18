package main;

/**
 * A subclass to represent an Onitama Controller between two Random Players.
 * Each Player will take turns making a move during the Onitama game play.
 * The OnitamaControllerRandomVSRandom subclass is inherited from the OnitamaController
 * superclass.
 */

public class OnitamaControllerRandomVSRandom extends OnitamaController {

    PlayerRandom player1, player2;

    /**
     * Constructs a new main.OnitamaControllerRandomVSRandom.
     * Sets up a new Onitama game between the Random Player
     * and another Random Player.
     */

    public OnitamaControllerRandomVSRandom() {
        super();
        this.player1 = new PlayerRandom(OnitamaBoard.G1);
        this.player2 = new PlayerRandom(OnitamaBoard.G2);
        this.onitama = new Onitama(player1, player2);
        this.player1.setOnitama(this.onitama);
        this.player2.setOnitama(this.onitama);
    }

    /**
     * Main function which creates and runs main.OnitamaControllerRandomVSRandom.
     */

    public static void main(String[] args) {

        OnitamaControllerRandomVSRandom oc = new OnitamaControllerRandomVSRandom();
        oc.play();
    }
}
