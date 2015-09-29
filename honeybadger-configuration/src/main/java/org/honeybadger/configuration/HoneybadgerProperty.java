package org.honeybadger.configuration;

import com.netflix.config.DynamicPropertyFactory;

/**
 * Created by Thijs Smeenk on 7-9-15.
 */
public class HoneybadgerProperty {

	private static final String DEFAULT_EMPTY_VALUE = "";

	public static String get(String property) {

		String determinedProperty = DynamicPropertyFactory.getInstance().getStringProperty(property, DEFAULT_EMPTY_VALUE).getValue();

		if (determinedProperty.equals(DEFAULT_EMPTY_VALUE)) {
			throw new IllegalStateException("Could not locate property: " + property);
		}

		return determinedProperty;
	}
}
