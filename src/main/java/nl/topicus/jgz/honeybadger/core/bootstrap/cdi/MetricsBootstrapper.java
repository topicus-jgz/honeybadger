package nl.topicus.jgz.honeybadger.core.bootstrap.cdi;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import nl.topicus.jgz.honeybadger.core.bootstrap.cdi.CDIBootstrap;

/**
 * Created by Thijs Smeenk on 10-8-15.
 */
public class MetricsBootstrapper implements CDIBootstrap {

	@Produces
	@ApplicationScoped
	private MetricRegistry metricRegistry() {
		MetricRegistry metricRegistry = new MetricRegistry();
		bootstrap(metricRegistry);

		return metricRegistry;
	}

	public void bootstrap(MetricRegistry metricRegistry) {
		metricRegistry.register("jvm.attribute", new JvmAttributeGaugeSet());
	}
}
