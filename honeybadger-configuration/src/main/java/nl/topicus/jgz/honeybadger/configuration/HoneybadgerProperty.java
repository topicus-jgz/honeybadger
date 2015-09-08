package nl.topicus.jgz.honeybadger.configuration;

import com.netflix.config.DynamicPropertyFactory;

/**
 * Created by Thijs Smeenk on 7-9-15.
 */
public class HoneybadgerProperty {

	private static final String EMPTY_STRING = "";

	public static String get(String property) {

		String determinedProperty = DynamicPropertyFactory.getInstance().getStringProperty(property, "").getValue();

		if (determinedProperty.equals(EMPTY_STRING)) {
			throw new IllegalStateException("Could not locate property: " + property);
		}

		return determinedProperty;
	}
}
