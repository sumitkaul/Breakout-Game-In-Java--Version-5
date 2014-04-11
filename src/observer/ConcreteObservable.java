package observer;

import java.util.ArrayList;

public class ConcreteObservable implements Observable {
	private ArrayList<Observer> observers;
	
	public ConcreteObservable()
	{
		observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer ob) {
		observers.add(ob);
	}

	@Override
	public void remove(Observer ob) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(ob);
		if (i >= 0) {
			observers.remove(i);
		}

	}
	
	public void notifyObservers()
	{
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			//need to send update
			observer.update();
		}
		
	}

}
