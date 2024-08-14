package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods{

	@Before
	public void start() throws InterruptedException {
		setUp();
	}
	@After
	public void end() {
		tearDown();
	}
}
