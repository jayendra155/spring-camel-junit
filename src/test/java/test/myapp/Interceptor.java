package test.myapp;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class Interceptor extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from(
		        "file://C:/NotBackedUp/Workspace/springcameltest/springcameltest/tmp/in?noop=true&fileName=*.xml")
		        .routeId("testFileRoute")
		        .process(new Processor() {

			        @Override
			        public void process(Exchange exchange) throws Exception {
				        System.out.println("yo!");
				        System.out.println(exchange.getIn().getBody(
				                String.class));
			        }
		        })
		        .to("file://C:/NotBackedUp/Workspace/springcameltest/springcameltest/tmp/afterTest");
	}

}
