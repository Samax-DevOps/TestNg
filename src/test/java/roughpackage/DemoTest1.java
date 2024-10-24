package roughpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest1 {

	@Test
	public void passTest() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void failTest() {
		Assert.assertTrue(false);
	}
}

