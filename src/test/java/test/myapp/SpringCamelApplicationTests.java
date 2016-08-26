package test.myapp;

import java.io.File;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.myapp.SpringCamelApplication;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringCamelApplication.class }, loader = CamelSpringDelegatingTestContextLoader.class)
public class SpringCamelApplicationTests extends CamelTestSupport {
	@Autowired
	private SpringCamelContext springCamelContext;
	@Produce(uri = "file://tmp/in?noop=true")
	private ProducerTemplate producer;
	@EndpointInject(uri = "mock:result")
	private MockEndpoint consumer;

	@Before
	public void setUp() throws Exception {
		springCamelContext.addRoutes(new RouteInterceptor());
	}

	@Test
	public void interceptorTest() {
		File file = new File("D:\\Project\\Workspace\\spring-camel-junit\\tmp\\intercepted");
		if (file.isDirectory()) {
			deleteDirectory(file);
			Assert.assertTrue(true);
		} else {
			fail("Unable to delete because file is not a directory");
		}

	}
}
