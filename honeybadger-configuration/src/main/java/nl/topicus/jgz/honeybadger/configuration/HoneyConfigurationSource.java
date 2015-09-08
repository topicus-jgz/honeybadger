package nl.topicus.jgz.honeybadger.configuration;

import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import nl.topicus.jgz.honeybadger.configuration.model.Property;

/**
 * {@link PolledConfigurationSource} that contacts Honey and loads the latest set of properties so they can be loaded into the configuration
 * contaxt.
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

		//Call Honey to get our latest set of properties
		Response response = callHoney();

		//Read the properties and place them in the map
		List<Property> propertyList = Arrays.asList(response.readEntity(new GenericType<>(Property[].class)));
		propertyList.forEach(property -> properties.put(property.key(), property.getValue()));

		return PollResult.createFull(properties);
	}

	private Response callHoney() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target(honeyUrl).request().get();

		if (response.getStatus() != 200) {
			throw new IllegalStateException("Cannot plug into Honey. Get operation failed! Tried url: " + honeyUrl);
		}
		return response;
	}
}
