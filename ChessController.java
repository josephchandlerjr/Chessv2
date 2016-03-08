import java.io.*;

public abstract class ChessController{
	ObjectInputStream whitePlayer;
	ObjectInputStream blackPlayer;
	ChessModel model;

	public ChessController(ObjectInputStream whitePlayer,
			       ObjectInputStream blackPlayer,
			       ChessModel model){
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.model = model;
	}
	public abstract void executeMove(int fromRow, int fromCol, int toRow, int toCol);
}

