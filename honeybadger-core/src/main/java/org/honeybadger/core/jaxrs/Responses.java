package org.honeybadger.core.jaxrs;

import java.net.URI;
import javax.ws.rs.core.Response;
import org.honeybadger.core.assertion.Assertions;

/**
 * Created by Thijs Smeenk on 17-8-15.
 */
public class Responses {

	/**
	 * Returns the proper HTTP reponse for the creation of a resource. Requires the path it's created on
	 */
	public static Response created(URI location) {
		return Assertions.validURI(location) ? Response.created(location).build() :
			   Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
}
