package com.myapp;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://tmp/in?noop=true")
		.to("file://tmp/out");
	}

}
