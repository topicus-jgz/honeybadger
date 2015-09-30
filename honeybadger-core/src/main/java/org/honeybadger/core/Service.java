package org.honeybadger.core;

import java.util.ArrayList;
import java.util.List;
import org.honeybadger.bootstrap.Configuration;
import org.honeybadger.bootstrap.PreDeploymentBootstrap;
import org.honeybadger.configuration.ConfigurationBootstrap;

import org.honeybadger.core.jaxrs.Resource;

/**
 * Base class for any microservice.
 * <p>
 * Created by Thijs Smeenk on 7-8-15.
 */
public abstract class Service {

	private Configuration configuration;

	protected Service() throws Exception {
		this.boostrap();
	}

	/**
	 * Call this method to org.honeybadger.honeybadger.bootstrap the service. Preferably from a psvm (public static void main)
	 */
	public void boostrap() throws Exception {
		configuration = new Configuration();

		//Configuration has to be bootstrapped first
		new ConfigurationBootstrap(System.getProperty("honey.url")).bootstrap(configuration);

		//bootstraps that do not rely on CDI or the container being started
		bootstraps().forEach(bootstrap -> bootstrap.bootstrap(configuration));

		//Doing the org.honeybadger.honeybadger.bootstrap on the container
		configuration.getContainer().start();

		//User setup of the container (adding classes etc)
		setup();

		//Deploying the container
		configuration.getJaxrsArchive().addAllDependencies();
		configuration.deployJaxRS();
	}

	protected List<PreDeploymentBootstrap> bootstraps() {
		return new ArrayList<>();
	}

	public abstract void setup();

	protected void registerResource(Class<? extends Resource> resourceClass) {
		assertBootstrapped();
		configuration.getJaxrsArchive().addResource(resourceClass);
	}

	protected void addClass(Class<?> classToAdd) {
		assertBootstrapped();
		configuration.getJaxrsArchive().addClass(classToAdd);
	}

	protected void addPackage(String pack) {
		assertBootstrapped();
		configuration.getJaxrsArchive().addPackage(pack);
	}

	private void assertBootstrapped() {
		if (configuration == null) {
			throw new IllegalStateException(
			 "Attempt to use the Configuration but the Configuration was NULL. Was the service bootstrapped before calling this method?");
		}
	}
}
