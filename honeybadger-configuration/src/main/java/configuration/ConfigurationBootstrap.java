package configuration;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;

import bootstrap.Configuration;
import bootstrap.PreDeploymentBootstrap;

/**
 * Created by Thijs Smeenk on 7-9-15.
 */
public class ConfigurationBootstrap implements PreDeploymentBootstrap {

	private final String honeyurl;

	public ConfigurationBootstrap(String honeyurl) {
		this.honeyurl = honeyurl;
	}

	@Override
	public void bootstrap(Configuration configuration) {
		DynamicConfiguration propertiesConfiguration =
		 new DynamicConfiguration(new HoneyConfigurationSource(honeyurl), new FixedDelayPollingScheduler(1000, 1000, true));

		ConfigurationManager.install(propertiesConfiguration);

		configuration.ok(this);
	}
}
