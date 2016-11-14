package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SenderClient implements Runnable{

	private PrintWriter objectOutputStream;
	private Client client;
	
	public SenderClient(Client client, PrintWriter outputStream) {
		super();
		this.client=client;
		this.objectOutputStream=outputStream;
	}
	
	@Override
	public void run() {
		
		this.objectOutputStream.println("test");
		this.objectOutputStream.flush();
		
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		
		this.objectOutputStream.println(msg);
		this.objectOutputStream.flush();
		
	}

}
