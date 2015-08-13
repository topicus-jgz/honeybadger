package nl.topicus.jgz.honeybadger.core;

import nl.topicus.jgz.honeybadger.core.jaxrs.Resource;

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
	 * Call this method to bootstrap the service. Preferably from a psvm (public static void main)
	 */
	public void boostrap() throws Exception {
		configuration = new Configuration();

		//Doing the bootstrap on the container
		configuration.getContainer().start();

		//User setup of the container (adding classes etc)
		setup();

		//Deploying the container
		configuration.deployJaxRS();

		configuration.getJaxrsDeployment().getArchive();
	}

	public abstract void setup();

	protected void registerResource(Class<? extends Resource> resourceClass) {
		assertBootstrapped();
		configuration.getJaxrsDeployment().addResource(resourceClass);
	}

	protected void addClass(Class<?> classToAdd) {
		assertBootstrapped();
		configuration.getJaxrsDeployment().getArchive().addClass(classToAdd);
	}

	private void assertBootstrapped() {
		if (configuration == null) {
			throw new IllegalStateException(
			 "Attempt to use the Configuration but the Configuration was NULL. Was the service bootstrapped?");
		}
	}
}
