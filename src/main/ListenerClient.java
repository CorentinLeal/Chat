package main;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ListenerClient implements Runnable{

	public ObjectInputStream objectInputStream;
	
	public ListenerClient(ObjectInputStream inputStream) {
		super();
		this.objectInputStream=inputStream;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(this.objectInputStream.readObject());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
