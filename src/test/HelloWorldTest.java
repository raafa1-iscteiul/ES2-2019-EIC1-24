package test;

import org.junit.jupiter.api.Test;

import compile.HelloWorld;

class HelloWorldTest {

	@Test
	void testMain() {
		HelloWorld.sayHiTo("Ricardo");
	}

}
