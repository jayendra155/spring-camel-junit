package test.myapp;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;

import com.myapp.SpringCamelApplication;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringCamelApplication.class }, loader = CamelSpringDelegatingTestContextLoader.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ContextTest {
	@Autowired
	private SpringCamelContext springCamelContext;
	@Produce(uri = "file://C:/NotBackedUp/Workspace/springcameltest/springcameltest/tmp/in?noop=true")
	private ProducerTemplate producer;
	@EndpointInject(uri = "mock:file://C:/NotBackedUp/Workspace/springcameltest/springcameltest/tmp/afterTest")
	protected MockEndpoint resultEndpoint;

	@Before
	public void setUp() throws Exception {
		springCamelContext.stopRoute("actualFileRoute");
		springCamelContext.addRoutes(new Interceptor());
	}

	@After
	public void tearDown() throws Exception {
	}

	@DirtiesContext
	@Test
	public void routeIsWorking() throws Exception {

		resultEndpoint
		        .expectedFileExists("C:/NotBackedUp/Workspace/springcameltest/springcameltest/tmp/afterTest/pom.xml");
		resultEndpoint.assertIsSatisfied();
	}

	/*
	 * @Test public void contextIsCreated() throws Exception {
	 * 
	 * if (null == springCamelContext) { fail("Not yet implemented"); } else {
	 * Assert.assertTrue(true); } }
	 */

}
