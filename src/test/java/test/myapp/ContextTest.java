package test.myapp;

import static org.junit.Assert.*;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.myapp.SpringCamelApplication;
import com.myapp.config.ApplicationContextProvider;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringCamelApplication.class, ApplicationContextProvider.class }, loader = CamelSpringDelegatingTestContextLoader.class)
public class ContextTest{
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

	@After
	public void tearDown() {
	}

	@Test
	public void contextIsInitializedOrNot() {

		if (null == springCamelContext) {
			fail("Not yet implemented");
		} else
			Assert.assertTrue(true);
	}

	
	}


