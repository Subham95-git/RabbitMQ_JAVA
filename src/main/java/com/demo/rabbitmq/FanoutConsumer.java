package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class FanoutConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		//Creating Connection Factory
		ConnectionFactory factory = new ConnectionFactory();

		//Creating Connection
		Connection connection = factory.newConnection();

		//creating Channel
		Channel channel = connection.createChannel();

		DeliverCallback deliverCallback = (consumerTag, delivery) ->{
			String message = new String(delivery.getBody());
			System.out.println("Message received: "+message);
		};

		channel.basicConsume("AC", true,deliverCallback, consumerTag -> {} );
	}

}
