package org.honeybadger.core.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Represents a Rest-Resource
 * <p>
 * Created by Thijs Smeenk on 10-8-15.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface Resource {

}
