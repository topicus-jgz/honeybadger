package nl.topicus.jgz.honeybadger.core.bootstrap.cdi;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

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
	public MetricRegistry produce() {
		MetricRegistry registry = new MetricRegistry();
		bootstrap(registry);

		return registry;
	}

	public void bootstrap(MetricRegistry metricRegistry) {
		metricRegistry.register("jvm.attribute", new JvmAttributeGaugeSet());
		metricRegistry.register("jvm.threads", new ThreadStatesGaugeSet());
	}
}
