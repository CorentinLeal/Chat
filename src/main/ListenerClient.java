package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ListenerClient implements Runnable{

	public BufferedReader objectInputStream;
	
	public ListenerClient(BufferedReader inputStream) {
		super();
		this.objectInputStream=inputStream;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(this.objectInputStream.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
