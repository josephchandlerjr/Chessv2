
public interface ChessModel extends Observable{
	public void takeAction(int fromRow,int fromCol,int toRow, int toCol);
	public ChessState getState();
}
