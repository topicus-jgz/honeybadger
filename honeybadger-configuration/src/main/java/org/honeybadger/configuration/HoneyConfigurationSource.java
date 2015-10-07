package org.honeybadger.configuration;

import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import com.sun.deploy.net.HttpResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.honeybadger.configuration.model.Property;

/**
 * {@link PolledConfigurationSource} that contacts Honey and loads the latest set of properties so they can be loaded into the configuration
 * context.
 * <p>
 * Created by Thijs Smeenk on 7-9-15.
 */
public class HoneyConfigurationSource implements PolledConfigurationSource {

	//Enviroment specifc
	private final String honeyUrl;

	public HoneyConfigurationSource(String honeyurl) {
		this.honeyUrl = honeyurl;
	}

	@Override
	public PollResult poll(boolean b, Object o) throws Exception {

		Map<String, Object> properties = new HashMap<>();
		String response = callHoney();

		//Read the properties and place them in the map
		ObjectMapper mapper = new ObjectMapper();
		List<Property> propertyList = Arrays.asList(mapper.readValue(response, Property[].class));
		propertyList.forEach(property -> properties.put(property.key(), property.getValue()));

		return PollResult.createFull(properties);
	}

	private String callHoney() {
		StringBuilder response = new StringBuilder();

		try {
			URL url = new URL(honeyUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
			if (responseCode == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String responseLine = null;

				while ((responseLine = in.readLine()) != null) {
					response.append(responseLine);
				}
				in.close();
			} else {
				throwException();
			}
		} catch (IOException e) {
			throwException();
		}
		return response.toString();
	}

	private HttpResponse throwException() {
		throw new IllegalStateException("Cannot plug into Honey. Get operation failed! Tried url: " + honeyUrl);
	}
}
