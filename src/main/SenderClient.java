package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SenderClient implements Runnable{

	private ObjectOutputStream objectOutputStream;
	private Client client;
	
	public SenderClient(Client client, ObjectOutputStream outputStream) {
		super();
		this.client=client;
		this.objectOutputStream=outputStream;
	}
	
	@Override
	public void run() {
		
		try {
			this.objectOutputStream.writeObject(("test").getBytes());
			this.objectOutputStream.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		
		try {
			this.objectOutputStream.writeObject(msg.getBytes());
			this.objectOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
