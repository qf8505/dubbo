package com.qf.farmer.util;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaUtil {
	private static Producer<String, String> producer = null;
	
	public static void main(String[] args) throws InterruptedException {
	}

	public static void send(String topic,String brokenList, String k, String v) {

		KeyedMessage<String, String> message = new KeyedMessage<String, String>(topic, k, v);
		if(producer==null){
			initProducer(brokenList);
		}
		producer.send(message);
	}

	private static synchronized void initProducer(String brokenList) {
		Properties props = new Properties();

		props.put("metadata.broker.list", brokenList);
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		// key.serializer.class默认为serializer.class
		props.put("key.serializer.class", "kafka.serializer.StringEncoder");
		props.put("request.required.acks", "1");
		props.put("serializer.encoding", "UTF-8");
		ProducerConfig config = new ProducerConfig(props);
		producer = new Producer<String, String>(config);
	}
}
