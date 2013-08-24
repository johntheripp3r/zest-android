package com.example.roboguice_demo.test.pojo;

import org.easymock.EasyMock;
import org.easymock.Mock;

import android.test.AndroidTestCase;

import com.example.roboguice_demo.lib.unittesting.easymock.EasyMockRoboAndroidTestCase;
import com.example.roboguice_demo.pojo.Computer2;
import com.example.roboguice_demo.pojo.Computer2Dependency;

/**
 * Tests a {@link Computer2}. As this class doesn't need any context, we can use a simple {@link AndroidTestCase}.
 * 
 * @author SNI
 */
public class Computer2UnitTest extends EasyMockRoboAndroidTestCase<Computer2> {

	private static final int TEST_VALUE = 48;

	@Mock
	private Computer2Dependency computer2Dependency;

	public Computer2UnitTest() {
		super(Computer2.class);
	}

	public void testComputeReturns42() {
		// given
		EasyMock.expect(computer2Dependency.compute()).andReturn(TEST_VALUE);
		replayAllMocks();

		// when
		int result = getInstanceUnderTest().compute();

		// test
		assertEquals(result, TEST_VALUE);
		verifyAllMocks();
	}
}
