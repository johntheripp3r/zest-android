package org.zest.integrationtesting.roboguice;

import org.zest.integrationtesting.MirrorInjector;

import roboguice.activity.RoboActivity;
import android.content.Loader;
import android.test.LoaderTestCase;

/**
 * This class will mock all dependencies of {@link RoboActivity}. <br>
 * It will receive the same injections as Activity under test if fields are declared in the same way as in this activity (same name, type and annotation).
 * 
 * @author SNI
 */
public class RoboLoaderTestCase extends LoaderTestCase {

	private MirrorInjector mirrorInjector = new MirrorInjector();

	@Override
	public <T> T getLoaderResultSynchronously(Loader<T> loader) {
		mirrorInjector.injectSameFieldsFromStuffUnderTestIntoTest(loader, this);
		return super.getLoaderResultSynchronously(loader);
	}
}