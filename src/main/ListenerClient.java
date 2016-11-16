package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class ListenerClient implements Runnable{

	public BufferedReader objectInputStream;
	private String message = null;
	
	public ListenerClient(BufferedReader inputStream) {
		super();
		this.objectInputStream=inputStream;
	}
	
	@Override
	public void run() {
		while(true){
	        try {
	        	
			message = objectInputStream.readLine();
			Date date = new Date();
			System.out.println(date.toString() + " - " +message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
