package main;

import java.util.ArrayList;
import java.util.Random;

/**
 * A subclass to represent a Random type Player (either G1 or G2).
 * The PlayerRandom is referred by the name of the Grandmaster and
 * will get a turn in which they make a random valid move.
 * The PlayerRandom subclass is inherited from the Player superclass.
 */

public class PlayerRandom extends Player {
    Onitama onitama;
    /**
     * Constructs a new main.PlayerRandom.
     * Sets up a Player's name by their
     * Grandmaster.
     *
     * @param player  name of the player
     */

    public PlayerRandom(char player) {
        super(player);
    }

    /**
     * Sets the instance of the current Onitama game.
     */
    public void setOnitama(Onitama o){
        this.onitama = o;
    }

    /**
     * Returns the player's grandmaster based on on RandomPlayer this.player
     * @param player integer representing a column on this board
     * @return player's grandmaster (G1 or G2)
     */
    public char player_grandmaster(char player) {
        if (player == OnitamaBoard.G1) {
            return OnitamaBoard.G1;
        }
        else {
            return OnitamaBoard.G2;
        }
    }

    /**
     * Returns the player's monk based on RandomPlayer this.player
     * @param player integer representing a column on this board
     * @return player's monk (M1 or M2)
     */
    public char player_monk(char player) {
        if (player == OnitamaBoard.G1) {
            return OnitamaBoard.M1;
        }
        else {
            return OnitamaBoard.M2;
        }
    }

    /**
     * Returns the destination row after applying row move to current row
     * depending on player's view
     * @param curr_row int representing a current row on this board
     * @param player_grandmaster char representing the RandomPlayer's grandmaster
     * @param style_move Move representing a move on this board
     * @return destination row
     */
    public int row_dest(int curr_row, char player_grandmaster, Move style_move) {
        if (player_grandmaster == OnitamaBoard.G1) {
            return curr_row + ((-1) * style_move.getRow());
        }
        else {
            return curr_row + style_move.getRow();
        }
    }

    /**
     * Returns the destination column after applying column move to current column
     * depending on player's view
     * @param curr_col int representing a current column on this board
     * @param player_grandmaster char representing the RandomPlayer's grandmaster
     * @param style_move Move representing a move on this board
     * @return destination column
     */
    public int col_dest(int curr_col, char player_grandmaster, Move style_move) {
        if (player_grandmaster == OnitamaBoard.G1) {
            return curr_col + ((-1) * style_move.getCol());
        }
        else {
            return curr_col + style_move.getCol();

        }
    }

    /**
     * Returns a randomly chosen valid potential turn by this player.
     *
     * @return Turn valid move
     */
    @Override
    public Turn getTurn() {

        Onitama onitama_inst = this.onitama;
        char[][] board_inst = onitama_inst.getBoard();
        System.out.println(onitama_inst.getBoardString());
        Style[] styles = onitama_inst.getStyles();
        ArrayList<Turn> valid_moves = new ArrayList<Turn>();
        char player_grandmaster = player_grandmaster(this.player);
        char player_monk = player_monk(this.player);

        for (int curr_row = 0; curr_row < onitama_inst.DIMENSION; curr_row++) {

            for (int curr_col = 0; curr_col < onitama_inst.DIMENSION; curr_col++) {

                for (int i = 0; i < styles.length; i++) {
                    Style curr_style = styles[i];
                    String name_style = styles[i].getName();

                    if (((board_inst[curr_row][curr_col] == player_grandmaster) ||
                            board_inst[curr_row][curr_col] == player_monk) &&
                            curr_style.getOwner() == this.player) {

                        for (int j = 0; j < curr_style.getMoves().length; j++) {
                            Move style_move = curr_style.getMoves()[j];
                            int dest_row = row_dest(curr_row, player_grandmaster, style_move);
                            int dest_col = col_dest(curr_col, player_grandmaster, style_move);;

                            if (onitama_inst.isLegalMove(curr_row, curr_col, dest_row, dest_col)) {
                                Turn valid_move = new Turn(curr_row, curr_col, dest_row, dest_col, name_style,
                                                            this.player);
                                valid_moves.add(valid_move);
                            }
                        }
                    }
                }
            }
        }

        if (valid_moves.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return valid_moves.get(random.nextInt(valid_moves.size()));
    }
}

