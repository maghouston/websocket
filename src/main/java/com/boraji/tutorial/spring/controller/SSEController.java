//package com.boraji.tutorial.spring.controller;
//
//import java.time.Duration;
//import java.time.LocalTime;
//
//import org.springframework.http.MediaType;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import reactor.core.publisher.Flux;
//
// 
// 
//
//
//@RestController
//@RequestMapping(path = "/sse")
//public class SSEController {
//	
//	
// 
//	//@Autowired
//	//KafkaReceiver<String,String> kafkaReceiver;
// 
//	/*@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	Mono<ServerResponse> getSimpleFlux(@Payload String record){
//		//Flux<ReceiverRecord<String,String>> kafkaFlux = kafkaReceiver.receive();
//		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//				.body(BodyInserters.fromObject(record == null ? "no news" : record));
//		 
//	}*/
//	
//	@GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	@KafkaListener(id = "foo", topics="test")
//	public Flux<String> streamFlux(@Payload String record) {
//	    return Flux.interval(Duration.ofSeconds(1))
//	      .map(sequence -> "Flux - " + LocalTime.now().toString()+ " "+record);
//	}
//	
//}