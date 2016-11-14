package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable{

	private final int PORT=8080;
	private final String ServerIp="127.0.0.1";
	private Socket socket;
	private String username;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	
	public Client(String username) {

		this.username=username;
		try {
			this.socket = new Socket(this.ServerIp, this.PORT);
			this.inputStream= new ObjectInputStream(this.socket.getInputStream());
			this.outputStream= new ObjectOutputStream(this.socket.getOutputStream());
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
		Client client = new Client("toto");
		System.out.println("Client created");
		client.run();
	}
	
}
