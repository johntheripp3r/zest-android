package com.example.roboguice_demo.test.infra;

import android.app.Application;
import android.test.InstrumentationTestCase;

import com.example.roboguice_demo.infra.Computer;
import com.example.roboguice_demo.pojo.Computer2;

/**
 * Tests a {@link Computer2}. As this class needs a context, we must use a simple {@link InstrumentationTestCase}.
 * 
 * @author SNI
 */
public class ComputerIntegrationTest extends InstrumentationTestCase {

	private static final int TEST_VALUE = 42;

	private Computer computer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.computer = new Computer((Application) getInstrumentation().getTargetContext().getApplicationContext());
	}

	public void testComputeReturns42() {
		// given

		// when
		int result = computer.compute();

		// test
		assertEquals(result, TEST_VALUE);
	}
}
