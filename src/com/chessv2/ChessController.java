package com.chessv2;

public interface ChessController extends Observer{

	public void takeAction(int fromRow, int fromCol, int toRow, int toCol);
	public void promote(int row, int col, String color, String piece);
	public void newGame();
	public void exit();
}

