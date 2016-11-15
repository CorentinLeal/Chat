package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SenderClient implements Runnable{

	private PrintWriter objectOutputStream;
	private Client client;
	private String login, message;
	private Scanner sc = null;
	
	public SenderClient(Client client, PrintWriter outputStream) {
		super();
		this.client=client;
		this.objectOutputStream=outputStream;
	}
	
	@Override
	public void run() {
		
		  sc = new Scanner(System.in);
		  
		  while(true){
			    System.out.println("Votre message :");
				message = sc.nextLine();
				objectOutputStream.println(message);
				objectOutputStream.flush();
			  }
	}
}
