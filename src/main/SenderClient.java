package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SenderClient implements Runnable{

	public ObjectOutputStream objectOutputStream;
	
	public SenderClient(ObjectOutputStream outputStream) {
		super();
		this.objectOutputStream=outputStream;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		
		try {
			this.objectOutputStream.writeObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
