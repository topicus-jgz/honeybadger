package org.honeybadger.bootstrap;

import java.util.ArrayList;
import java.util.List;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * Created by Thijs Smeenk on 7-8-15.
 */
public class Configuration {

	private final Container container;
	private final JAXRSArchive jaxrsArchive;
	private final List<BootstrappedModules> modulesList;

	public Configuration() throws Exception {
		this.container = new Container();
		this.jaxrsArchive = ShrinkWrap.create(JAXRSArchive.class);
		this.modulesList = new ArrayList<>();
	}

	public Container getContainer() {
		return container;
	}

	public JAXRSArchive getJaxrsArchive() {
		return jaxrsArchive;
	}

	public void deployJaxRS() throws Exception {
		this.container.deploy(jaxrsArchive);
	}

	public void ok(PreDeploymentBootstrap bootstrap) {
		modulesList.add(new BootstrappedModules(bootstrap));
	}

	private class BootstrappedModules {

		private final String name;

		public BootstrappedModules(PreDeploymentBootstrap bootstrap) {
			this.name = bootstrap.getClass().getCanonicalName();
		}

		public String getName() {
			return name;
		}
	}
}
