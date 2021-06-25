package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Publisher {

	public static void main(String[] args) throws IOException, TimeoutException {

		
		//Creating Connection Factory
		ConnectionFactory factory = new ConnectionFactory();
		
		//Creating Connection
		Connection connection = factory.newConnection();
		
		//creating Channel
		Channel channel = connection.createChannel();
		
		//Message
		String[] messages = {"First", "Second", "Third", "Fourth"};
		
		//Publish the message
		for(String message: messages) {
			channel.basicPublish("", "Queue-1", null, message.getBytes());
		}
		//channel.basicPublish("", "Queue-1", null, message.getBytes());
		
		channel.close();
		connection.close();
		

	}

}
