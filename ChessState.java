
import java.awt.*;


/**
 * class representing state of a chess game
 * that is passed from model to view
 */
public class ChessState{
	Image[][] board;//just color and piece ex: BP or WQ
	String toMove;
	boolean whiteInCheck;
	boolean blackInCheck;
	boolean whiteHasWon;
	boolean blackHasWon;

	public ChessState(Image[][] board){
		this.board = board;
		toMove = "WHITE";
	}
	
}
