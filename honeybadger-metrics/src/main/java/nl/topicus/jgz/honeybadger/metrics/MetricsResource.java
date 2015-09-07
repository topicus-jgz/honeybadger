package nl.topicus.jgz.honeybadger.metrics;

import com.codahale.metrics.MetricRegistry;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by Thijs Smeenk on 10-8-15.
 */
@Path(value = "/metrics")
public class MetricsResource {

	@Inject
	private MetricRegistry metricRegistry;

	@GET
	public Response get() {
		return Response.ok(metricRegistry.getMetrics()).build();
	}
}
