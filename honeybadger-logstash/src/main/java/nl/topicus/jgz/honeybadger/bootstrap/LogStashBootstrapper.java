package nl.topicus.jgz.honeybadger.bootstrap;

import org.wildfly.swarm.logstash.LogstashFraction;

import nl.topicus.jgz.honeybadger.configuration.HoneybadgerProperty;

/**
 * Created by Thijs Smeenk on 17-8-15.
 */
public class LogStashBootstrapper implements PreDeploymentBootstrap {

	private static final String EMPTY = "";
	private String hostname = HoneybadgerProperty.get("common.logstash.hostname");
	private String level = HoneybadgerProperty.get("common.logstash.level");
	private String port = HoneybadgerProperty.get("common.logstash.port");

	public void bootstrap(Configuration configuration) {

		if (hostname.equals(EMPTY) || level.equals(EMPTY) || port.equals(EMPTY)) {
			throw new IllegalStateException(
			 "Attempt to use honeybader-logstash but not all required properties are set! Check your honey deployment");
		}

		configuration.getContainer().subsystem(new LogstashFraction().hostname(hostname).level(level).port(port));
		configuration.ok(this);
	}
}
