
public class ChessControllerImpl extends ChessController{
	public ChessControllerImpl(ChessPlayer whitePlayer,ChessPlayer blackPlayer, ChessModel model;
		super(whitePlayer,blackPlayer, model);
	}

        public void executeMove(int fromRow, int fromCol, int toRow, int toCol){
		model.executeMove();
	}

	public void newGame(){
		Thread game = new Thread(new 
		ChessPlayer[] players = {whitePlayer,blackPlayer};
		int count = 0;
		while(true){

		}

	}

        public void executeMove(int fromRow, int fromCol, int toRow, int toCol){
		controller.executeMove(fromRow, fromCol, toRow, toCol);
	}
	/**
	 * executes a move
	 * synchronized for remote games who's moves come in via thread
	 */	
	public synchronized void executeMove(String myColor, Square fromSquare, String fromNotation, String toNotation, Square toSquare) {
		if(!fromSquare.isOccupied()){ return;} //must be moving a piece
		String pieceColor = fromSquare.getPieceColor();
		
		// must be piece of my color and must be my turn
	        if(!pieceColor.equals(myColor) || !pieceColor.equals(game.player)){ return;} 
		
		ChessNotation notation = new ChessNotation(fromNotation+toNotation);
		if ("Ke1c1Ke8c8".contains(fromNotation+toNotation)){
			notation = new ChessNotation("O-O-O");
		}
		else if ("Ke1g1Ke8g8".contains(fromNotation+toNotation)){
			notation = new ChessNotation("O-O");
		}

		Move move = new Move(notation, myColor, fromSquare, toSquare);

		boolean isPawn = ChessPiece.isPawn(fromSquare.getPiece());
		boolean executed = game.takeAction(move);
 
		// check if we need to promote pawn and if remote game send move made over socket
		if (executed){
			if(localGame){
				this.myColor = game.player; //set instance variable not local variable
			}
			else {
				try{
					//fromRow,fromCol, fromNotion, toNotation, toSquare,fromSquare
					int[] coord = {fromSquare.getRow(),fromSquare.getCol(),
						       toSquare.getRow(), toSquare.getCol()};
					String[] notations = {fromNotation,toNotation};
					oos.writeObject(coord);
					oos.writeObject(notations);
				}catch(Exception ex){
					JOptionPane.showMessageDialog( null,
								      "Connection to server lost",
								      "Bad Connection",
								      JOptionPane.WARNING_MESSAGE);
					gui.frame.dispose();
				}
			}
			if(isPawn){
				int row = toSquare.getRow(); 
				if( row == 0 || row == 7){
					promotePawn(toSquare);
					game.updateCheckStatus();
				}
			}
			gui.frame.repaint();
			setStatus();
		}
	}
}
