package org.honeybadger.bootstrap;


/**
 * Created by Thijs Smeenk on 10-8-15.
 */
public interface PreDeploymentBootstrap {

	void bootstrap(Configuration configuration);
}
