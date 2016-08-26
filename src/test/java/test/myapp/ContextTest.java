package test.myapp;

import static org.junit.Assert.*;


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

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringCamelApplication.class }, loader = CamelSpringDelegatingTestContextLoader.class)
public class ContextTest {
	@Autowired
	private SpringCamelContext springCamelContext;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test() {

		if (null == springCamelContext) {
			fail("Not yet implemented");
		} else
			Assert.assertTrue(true);
	}

}
