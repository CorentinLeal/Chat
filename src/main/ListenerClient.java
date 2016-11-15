package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;

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
			System.out.println("Le serveur vous dit :" +message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
