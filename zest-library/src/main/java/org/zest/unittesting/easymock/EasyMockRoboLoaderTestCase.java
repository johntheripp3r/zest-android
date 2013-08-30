package org.zest.unittesting.easymock;

import org.zest.integrationtesting.roboguice.RoboLoaderTestCase;
import org.zest.unittesting.MockInjector;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import android.app.Application;

/**
 * This class will mock all dependencies of {@link RoboActivity}. <br>
 * It will use a custom RoboGuice module to bind the mocked dependencies to RoboGuice so that mocks are injected automatically inside class under test.
 * It will receive the same injections as Activity under test if fields are declared in the same way as in this activity (same name, type and annotation).
 * 
 * @author SNI
 */
public class EasyMockRoboLoaderTestCase extends RoboLoaderTestCase {

	private EasyMockTestModule easyMocktestModule;
	private MockInjector mockInjector;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// for android 4.3 devices / emulator only
		// https://code.google.com/p/dexmaker/issues/detail?can=2&start=0&num=100&q=&colspec=ID%20Type%20Status%20Priority%20Milestone%20Owner%20Summary&groupby=&sort=&id=2
		System.setProperty("dexmaker.dexcache", getContext().getCacheDir().toString());

		mockInjector = new MockInjector(this);
		easyMocktestModule = new EasyMockTestModule(mockInjector.getMapClassToMock());
		setUpMockModuleForTest();
	}

	private void setUpMockModuleForTest() {
		Application application = (Application) getContext().getApplicationContext();
		// we use both a usual module and our module
		RoboGuice.setBaseApplicationInjector(application, RoboGuice.DEFAULT_STAGE, RoboGuice.newDefaultRoboModule(application), easyMocktestModule);
	}

	@Override
	protected void tearDown() throws Exception {
		RoboGuice.util.reset();
		mockInjector.resetAllMocks();
		super.tearDown();
	}

	protected EasyMockTestModule getEasyMocktestModule() {
		return easyMocktestModule;
	}

	// -------------------------------
	// FACADE / DELEGATION on EasyMockTestModule
	// -------------------------------
	public void resetAllMocks() {
		mockInjector.resetAllMocks();
	}

	public void replayAllMocks() {
		mockInjector.replayAllMocks();
	}

	public void verifyAllMocks() {
		mockInjector.verifyAllMocks();
	}

}