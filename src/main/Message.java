package main;

public class Message {

	private String content;
	private Client from;
	
	public Message(String content, Client client) {
		this.content=content;
		this.from=client;
	}
	
	
}
