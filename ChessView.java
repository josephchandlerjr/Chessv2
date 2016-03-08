import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.util.*;
import javax.imageio.*;

public class ChessView implements Observer{
	ChessController controller;
	ChessModel model;

	Color blackSquareColor = new Color(102,51,0);
	Color whiteSquareColor = Color.white;

	JFrame frame;
	JPanel mainPanel;

	public ChessView(ChessController controller, ChessModel model){
		this.controller = controller;
		this.model = model;
		//model.registerObserver(this);
		build();
	}
	public void update(){
		ChessState state = model.getState();
		//do something with State object
	}

        public void executeMove(int fromRow, int fromCol, int toRow, int toCol){
		//controller.executeMove(fromRow, fromCol, toRow, toCol);
	}

	public void build(){
		frame = new JFrame("CHESS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(8,8);
		grid.setVgap(1);
		grid.setHgap(1);
		mainPanel = new JPanel(grid);
		mainPanel.setPreferredSize(new Dimension(70*8,70*8));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		initialize();
	
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

		frame.pack();
		frame.setVisible(true);
	}
	public Color otherSquareColor(Color c){
		if(c == blackSquareColor){
			return whiteSquareColor;
		}
		return blackSquareColor;
	}
	public void initialize(){
		BoardListener listener = new BoardListener();
		Color squareColor = whiteSquareColor;
		for (int row = 0; row < 8; row++){
			squareColor = otherSquareColor(squareColor);
			for (int col = 0; col < 8; col++){
				SquarePanel p = new SquarePanel(row, col);
				p.setColor(squareColor);
				p.addMouseListener(listener);
				mainPanel.add(p);
				squareColor = otherSquareColor(squareColor);
			}
		}
	}

	class BoardListener implements MouseListener {
		MouseEvent lastEntered;
		MouseEvent lastPressed;

		public void mouseClicked(MouseEvent e){}
		public void mouseEntered(MouseEvent e){
			lastEntered = e;
		}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){
			lastPressed = e;
		}
		public void mouseReleased(MouseEvent e){
			SquarePanel from = (SquarePanel)(lastPressed.getSource());
			SquarePanel to = (SquarePanel)(lastEntered.getSource());
			System.out.printf("%s%s %s%s\n",from.row, from.col, to.row, to.col);
			executeMove(from.row,from.col,to.row,to.col);
		}  
	}//end inner class BoardListener
}

class SquarePanel extends JPanel {
	int row;
	int col;
	Color color;
	Image image;

	public SquarePanel(int row, int col){
		this.row = row;
		this.col = col;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public void setImageIcon(Image image){
		this.image = image;
	}
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		if (image != null) {
			g.drawImage(image,10,10,this);
		}
	}
}


