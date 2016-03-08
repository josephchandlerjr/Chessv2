
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/** 
 * represents a square on the chess board
 */
public class Square{
	private final int ROW;
	private final int COL;
	private ChessPiece piece;
	private ChessPiece previousPiece;
	private Square EAST;
	private Square WEST;


	/**
	 * create new square
	 * @param row row square resides in
	 * @param col col square resides in 
	 */
	public Square(int row, int col){
		this.ROW = row;
		this.COL = col;
		this.piece = null;
	}

	//helper methods when castling
	public void setEAST(Square e){ EAST = e;}
	public void setWEST(Square w){ WEST = w;}
	public Square east(){
	       return EAST;
	}	       
	public Square west(){
		return WEST;
	}
	
	public ChessPiece getPreviousPiece()
	{
		return previousPiece;
	}
	/**
	 * places piece on this square
	 * @param piece ChessPiece object to put on this square
	 */
	public void setPiece(ChessPiece piece)
	{
		this.previousPiece = this.piece;
		this.piece = piece;
	}
	/**
	 * gets piece on this square
	 * @return piece on this square or null if there is none
	 */
	public ChessPiece getPiece()
	{
		return piece;
	}
	/**
	 * gets the string representation of piece on this square
	 * @return string representation of piece
	 */
	public String toString()
	{
		if (piece == null)
		{ return null;}
		return piece.toString();
	}

	/**
	 * gets row
	 * @return the row number of piece
	 */
	public int getRow()
	{
		return ROW;
	}

	/**
	 * gets column of piece
	 * @return the column number of piece
	 */
	public int getCol()
	{
		return COL;
	}

	/**
	 * gets color of piece sitting on square
	 * @return color of piece on square
	 */
	public String getPieceColor()
	{
		if (piece == null){
			return "";
		}
		return piece.getColor();
	}

	/**
	 * checks if given position is occupied by a piece 
	 * @param piece ChessPiece reference at given location on board
	 * @return true if parameter given is not a pointer to null
	 */
	public boolean isOccupied()
	{
		return piece != null;
	}
}

