package nl.topicus.jgz.honeybadger.core.bootstrap;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Thijs Smeenk on 10-8-15.
 */
@Singleton
public class MetricsBootstrapper implements Bootstrap {

	@Inject
	private MetricRegistry metricRegistry = new MetricRegistry();

	public void bootstrap() {
		metricRegistry.register("jvm.attribute", new JvmAttributeGaugeSet());
	}

	@PostConstruct
	public void print() {
		System.err.println("error");
	}
}
