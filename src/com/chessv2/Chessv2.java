package com.chessv2;

public class Chessv2{
	public static void main(String[] args){
		ChessModel model = new ChessModelImpl();
		ChessController controller = new ChessControllerImpl(null,null,model);
	}
}
