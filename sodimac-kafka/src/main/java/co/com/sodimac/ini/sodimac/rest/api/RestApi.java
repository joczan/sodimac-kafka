package co.com.sodimac.ini.sodimac.rest.api;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestApi extends RouteBuilder{

		
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
//	restConfiguration().component("servlet")
//	.host("localhost")
//	.port(8181)
//	//.bindingMode(org.apache.camel.model.rest.RestBindingMode.json)
//	;

		// Post
		rest().path("/sodimac/kafka")
		.post("/RecaudoComision")
		//.consumes("application/vnd.kafka.json.v2+json")
		//.consumes("application/json")
		.produces("application/vnd.kafka.json.v2+json")
		//.responseMessage("200", "Producer Succesful")
				
		.to("bean:co.com.sodimac.ini.sodimac.rest.api.EncodeBase64?method=enconde(${body},true)")
		//.to("log:${body}");
		//.to("log:DEBUG?showBody=true&showHeaders=true")
	//	.to("http://kafka-bridge-amq-kafka-sodimac.mycluster-dal13-b3-998920-8084f73606e0971bbf41e6bc7515d8d1-0000.us-south.containers.appdomain.cloud/consumers/my-topic-consumer-group/instances/my-topic-consumer-1/records?bridgeEndpoint=true")
		;
		//.to("log:DEBUG?showBody=true&showHeaders=true");
		//.to("log:${body}");
		
		// Methodo Get
		rest().path("/sodimac/kafka")
		.get("/RecaudoComision")
//		.consumes("application/vnd.kafka.binary.v2+json")
//		.produces("application/vnd.kafka.binary.v2+json")
		.consumes("application/json")
		.produces("application/vnd.kafka.binary.v2+json")
		.responseMessage("200", "Consumo Exitoso")
		.to("bean:co.com.sodimac.ini.sodimac.rest.api.EncodeBase64?method=enconde()")
		.to("http://kafka-bridge-amq-kafka-sodimac.mycluster-dal13-b3-998920-8084f73606e0971bbf41e6bc7515d8d1-0000.us-south.containers.appdomain.cloud/consumers/my-topic-consumer-group/instances/my-topic-consumer-1/records")
		.to("log:${body}");
		//.to("log:${body}");
		//.to("bean:co.com.sodimac.ini.sodimac.rest.utils.LecturaProps?method=bye");
		//.to("file:./target/reports?fileName=${header.token}.json");
				//	.to("bean:LecturaProps?method=myProperties")
				//	.to("direct:hello");
				
		
		//https://camel.apache.org/components/next/quartz-component.html
//		from("cron:tokenizar?schedule=0/2 * * * * MON-FRI ")
//		.to("bean:co.com.sodimac.ini.sodimac.rest.utils.LecturaProps?method=myProperties")
//		.log("${body} Tokenizado");
		
		/**
		 * KAFKA ROUTES
		 */
//		from("kafka:my-topic?brokers=http://my-cluster-kafka-bootstrap.amq-kafka-sodimac.svc:9092")
//	    .log("Message received from Kafka : ${body}")
//	    .log("    on the topic ${headers[kafka.TOPIC]}")
//	    .log("    on the partition ${headers[kafka.PARTITION]}")
//	    .log("    with the offset ${headers[kafka.OFFSET]}")
//	    .log("    with the key ${headers[kafka.KEY]}");
		
		from("direct:hello")
		 .to("log:${body}");
		//.transform().constant("Hello World");
	}

}
