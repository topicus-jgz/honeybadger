package org.honeybadger.bootstrap;

import org.honeybadger.configuration.HoneybadgerProperty;
import org.wildfly.swarm.hawkular.HawkularFraction;

/**
 * Created by tlhs on 20-10-15.
 */
public class HawkularBootstrap implements PreDeploymentBootstrap {

    //host info
    private String host = HoneybadgerProperty.getStringProperty("hawkular.host");
    private Integer port = HoneybadgerProperty.getIntegerProperty("hawkular.port");

    //user info
    private String user = HoneybadgerProperty.getStringProperty("hawkular.user");
    private String password = HoneybadgerProperty.getStringProperty("hawkular.password");

    @Override
    public void bootstrap(Configuration configuration) {
        configuration.getContainer().fraction(new HawkularFraction()
                .host(host).port(port).username(user).password(password));
    }
}
