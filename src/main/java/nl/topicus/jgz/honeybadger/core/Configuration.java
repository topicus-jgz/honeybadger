package nl.topicus.jgz.honeybadger.core;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * Created by Thijs Smeenk on 7-8-15.
 */
public class Configuration {

	private final Container container;
	private final JAXRSArchive jaxrsArchive;

	protected Configuration() throws Exception {
		this.container = new Container();
		this.jaxrsArchive = ShrinkWrap.create(JAXRSArchive.class);
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
}
