package com.chessv2;

public interface Observable{
	public void registerObserver(Observer obs);
	public void notifyObservers();
}
