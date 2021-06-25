package com.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		//Creating Connection Factory
		ConnectionFactory factory = new ConnectionFactory();

		//Creating Connection
		Connection connection = factory.newConnection();

		//creating Channel
		Channel channel = connection.createChannel();

		String message= "Message for Mobile and AC";

		channel.basicPublish("Topic-Exchange", "tv.mobile.ac", null, message.getBytes());

		channel.close();
		connection.close();

	}

}
