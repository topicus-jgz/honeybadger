package nl.topicus.jgz.honeybadger.metrics.bootstrap;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.elasticsearch.metrics.ElasticsearchReporter;

import nl.topicus.jgz.honeybadger.bootstrap.cdi.CDIBootstrap;

/**
 * Producer for {@link MetricRegistry}. Sets some defaults gauges
 * <p>
 * Created by Thijs Smeenk on 10-8-15.
 */
@Startup
@ApplicationScoped
public class MetricsBootstrapper implements CDIBootstrap<MetricRegistry> {

	@Produces
	@ApplicationScoped
	public MetricRegistry produce() throws IOException {
		MetricRegistry registry = new MetricRegistry();
		bootstrap(registry);

		ElasticsearchReporter reporter = ElasticsearchReporter.forRegistry(registry).hosts("localhost:9200").build();
		reporter.start(5, TimeUnit.SECONDS);

		return registry;
	}

	@Produces
	@ApplicationScoped
	public HealthCheckRegistry healthCheckRegistry() {
		return new HealthCheckRegistry();
	}

	public void bootstrap(MetricRegistry metricRegistry) {
		metricRegistry.register("jvm.attribute", new JvmAttributeGaugeSet());
		metricRegistry.register("jvm.threads", new ThreadStatesGaugeSet());
	}
}
