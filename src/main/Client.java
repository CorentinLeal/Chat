package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable{

	private final int PORT=5050;
	private final String ServerIp="127.0.0.1";
	private Socket socket;
	private String username;
	private BufferedReader inputStream;
	private PrintWriter outputStream;
	
	public Client(String username) {

		this.username=username;
		try {
			this.socket = new Socket(this.ServerIp, this.PORT);
			this.inputStream= new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.outputStream= new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Unable to connect.");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		
		Thread emission = new Thread(new SenderClient(this, this.outputStream));
		emission.start();
		Thread reception = new Thread(new ListenerClient(this.inputStream));
		reception.start();
		System.out.println("Client Started");
		
	}
	
	public static void main(String[] args) {
		System.out.println("Client created");
		Client client = new Client("toto");
		client.run();
	}
	
}
