package nl.topicus.jgz.honeybadger.bootstrap;

import nl.topicus.jgz.honeybadger.configuration.Configuration;

/**
 * Created by Thijs Smeenk on 10-8-15.
 */
public interface PreDeploymentBootstrap {

	void bootstrap(Configuration configuration);
}
