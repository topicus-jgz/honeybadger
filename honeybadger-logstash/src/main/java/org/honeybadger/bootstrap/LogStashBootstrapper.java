package org.honeybadger.bootstrap;

import org.honeybadger.configuration.HoneybadgerProperty;
import org.wildfly.swarm.logstash.LogstashFraction;

/**
 * Adds the logstash fraction to a HoneyBadger based microservice.
 * <p>
 * Created by Thijs Smeenk on 17-8-15.
 */
public class LogStashBootstrapper implements PreDeploymentBootstrap {

    private static final String EMPTY = "";
    private String hostname = HoneybadgerProperty.getStringProperty("common.logstash.hostname");
    private String level = HoneybadgerProperty.getStringProperty("common.logstash.level");
    private String port = HoneybadgerProperty.getStringProperty("common.logstash.port");

    public void bootstrap(Configuration configuration) {

        if (hostname.equals(EMPTY) || level.equals(EMPTY) || port.equals(EMPTY)) {
            throw new IllegalStateException(
                    "Attempt to use honeybader-logstash but not all required properties are set!");
        }

        configuration.getContainer().subsystem(new LogstashFraction().hostname(hostname).level(level).port(port));
        configuration.ok(this);
    }
}
