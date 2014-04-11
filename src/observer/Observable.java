package observer;

public interface Observable {
	
	void register(Observer ob);
	void remove(Observer ob);
	void notifyObservers();
}
