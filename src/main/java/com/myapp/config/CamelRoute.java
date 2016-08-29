package com.myapp.config;

import org.apache.camel.builder.RouteBuilder;

public class CamelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://C:/NotBackedUp/Workspace/springcameltest/springcameltest/tmp/in?noop=true")
		.routeId("actualFileRoute")
			.to("file://C:/NotBackedUp/Workspace/springcameltest/springcameltest/tmp/out");
	}

}
