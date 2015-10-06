package org.honeybadger.metrics.bootstrap;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.elasticsearch.metrics.ElasticsearchReporter;
import org.honeybadger.bootstrap.cdi.CDIBootstrap;
import org.honeybadger.configuration.HoneybadgerProperty;

/**
 * Producer for {@link MetricRegistry}. Sets some defaults gauges
 * <p>
 * Created by Thijs Smeenk on 10-8-15.
 */
@Startup
@ApplicationScoped
public class MetricsBootstrapper implements CDIBootstrap<MetricRegistry> {

	private String uri = HoneybadgerProperty.get("common.metrics.eleasticsearch");

	@Produces
	@ApplicationScoped
	public MetricRegistry produce() throws IOException {

		if (uri.equals("")) {
			throw new IllegalStateException("common.metrics.eleasticsearch is empty! Cannot report to logstash");
		}

		MetricRegistry registry = new MetricRegistry();
		bootstrap(registry);

		ElasticsearchReporter reporter = ElasticsearchReporter.forRegistry(registry).hosts(uri).build();
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
	}
}
