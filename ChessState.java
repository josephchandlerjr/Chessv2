
import java.awt.*;


/**
 * class representing state of a chess game
 * that is passed from model to view
 */
public class ChessState{
	String[][] board;//just color and piece ex: BP or WQ
	String toMove;
	boolean whiteInCheck;
	boolean blackInCheck;
	boolean whiteHasWon;
	boolean blackHasWon;

	public ChessState(){
		this.board = new String[8][8];
		toMove = "WHITE";
	}
	
}

