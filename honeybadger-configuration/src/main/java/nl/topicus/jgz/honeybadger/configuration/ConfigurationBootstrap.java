package nl.topicus.jgz.honeybadger.configuration;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;

import nl.topicus.jgz.honeybadger.bootstrap.PreDeploymentBootstrap;

/**
 * Created by Thijs Smeenk on 7-9-15.
 */
public class ConfigurationBootstrap implements PreDeploymentBootstrap {

	@Override
	public void bootstrap(Configuration configuration) {
		DynamicConfiguration propertiesConfiguration =
		 new DynamicConfiguration(new HoneyConfigurationSource(), new FixedDelayPollingScheduler(1000, 1000, true));

		ConfigurationManager.install(propertiesConfiguration);

		configuration.ok(this);
	}
}
