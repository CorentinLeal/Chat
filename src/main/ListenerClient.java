package main;

import java.io.ObjectInputStream;

public class ListenerClient implements Runnable{

	public ObjectInputStream objectInputStream;
	
	public ListenerClient(ObjectInputStream inputStream) {
		super();
		this.objectInputStream=inputStream;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
