import java.io.*;

public class ChessControllerImpl extends ChessController{
	public ChessControllerImpl(ObjectInputStream whitePlayer,ObjectInputStream blackPlayer, ChessModel model){
		super(whitePlayer,blackPlayer, model);
	}

        public void takeAction(int fromRow, int fromCol, int toRow, int toCol){
		model.takeAction(fromRow, fromCol, toRow, toCol);
	}

}
