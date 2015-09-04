package nl.topicus.jgz.honeybadger.bootstrap;

import org.wildfly.swarm.logstash.LogstashFraction;

import nl.topicus.jgz.honeybadger.core.Configuration;
import nl.topicus.jgz.honeybadger.core.bootstrap.PreDeploymentBootstrap;

/**
 * Created by Thijs Smeenk on 17-8-15.
 */
public class LogStashBootstrapper implements PreDeploymentBootstrap {

	public void bootstrap(Configuration configuration) {
		configuration.getContainer().subsystem(new LogstashFraction().hostname("localhost").level("INFO").port("8000"));
	}
}
