package com.demo.rabbitmq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class HeaderPublisher {

	public static void main(String[] args)throws IOException, TimeoutException {
		//Creating Connection Factory
		ConnectionFactory factory = new ConnectionFactory();

		//Creating Connection
		Connection connection = factory.newConnection();

		//creating Channel
		Channel channel = connection.createChannel();

		String message= "Message for mobile and tv";
		
		Map<String, Object> headersMap = new HashMap<String, Object>();
		headersMap.put("item1", "mobile");
		headersMap.put("item2", "television");
		
		BasicProperties br = new BasicProperties();
		br = br.builder().headers(headersMap).build();

		channel.basicPublish("Header-Exchange", "", br, message.getBytes());

		channel.close();
		connection.close();
	}

}


