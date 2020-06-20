package com.henrique.kafka;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "java_in_use_topic";
        
	
	public void send(String message) {
            System.out.println("AAAAAAA");
            try { 
                System.out.println(kafkaTemplate.send(kafkaTopic, message).get());
            } catch (InterruptedException ex) {
                Logger.getLogger(KafkaSender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(KafkaSender.class.getName()).log(Level.SEVERE, null, ex);
            }
	    
	}
}