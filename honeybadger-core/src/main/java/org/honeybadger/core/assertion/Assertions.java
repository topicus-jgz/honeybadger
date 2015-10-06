package org.honeybadger.core.assertion;

import java.net.URI;

/**
 * Created by Thijs Smeenk on 14-8-15.
 */
public class Assertions {

	public static boolean validURI(URI location) {
		return location != null || location.getRawPath() != null;
	}
}
