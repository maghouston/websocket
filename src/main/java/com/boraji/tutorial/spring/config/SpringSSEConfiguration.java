package com.boraji.tutorial.spring.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
 

@Configuration
@EnableKafka
class SpringSSEConfiguration {
	 
	private static Map<String, Object> configProps = new HashMap<>(); 
	private static String bootstrapAddress = "0.0.0.0:9092";
	static {
		configProps.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put( ConsumerConfig.CLIENT_ID_CONFIG, "id-client");
		configProps.put( ConsumerConfig.GROUP_ID_CONFIG, "sample-group");
		configProps.put( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
	}
	
 	
	   @Bean
	    ConcurrentKafkaListenerContainerFactory<Integer, String>
	                        kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
	                                new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }

	    @Bean
	    public DefaultKafkaConsumerFactory<Integer, String> consumerFactory() {
	        return new DefaultKafkaConsumerFactory<Integer, String>(configProps);
	    }
	    
	
}