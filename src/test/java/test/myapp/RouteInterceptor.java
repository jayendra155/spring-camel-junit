package test.myapp;

import org.apache.camel.builder.RouteBuilder;

public class RouteInterceptor extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		interceptFrom("file://tmp/in?noop=true")
		.to("file://tmp/intercepted");
	}

}
