package nl.topicus.jgz.honeybadger.core.jaxrs;

import com.codahale.metrics.annotation.Metered;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Represents a Rest-Resource
 * <p>
 * Created by Thijs Smeenk on 10-8-15.
 */
@Metered
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class Resource {

	@PostConstruct
	public void printCreation() {
		System.err.println("Created: " + this.getClass().getName());
	}
}
