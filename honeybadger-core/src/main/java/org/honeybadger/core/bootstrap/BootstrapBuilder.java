package org.honeybadger.core.bootstrap;

import org.honeybadger.bootstrap.Configuration;
import org.honeybadger.bootstrap.PreDeploymentBootstrap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tlhs on 20-10-15.
 */
public class BootstrapBuilder {

    private final Set<PreDeploymentBootstrap> bootstraps = new HashSet<>();

    public BootstrapBuilder add(PreDeploymentBootstrap bootstrap) {
        this.bootstraps.add(bootstrap);
        return this;
    }

    public void bootstrap(Configuration configuration) {
        bootstraps.forEach(b -> b.bootstrap(configuration));
    }

    public static BootstrapBuilder start() {
        return new BootstrapBuilder();
    }
}
