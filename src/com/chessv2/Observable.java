
public interface Observable{
	public void registerObserver(Observer obs);
	public void notifyObservers();
}
