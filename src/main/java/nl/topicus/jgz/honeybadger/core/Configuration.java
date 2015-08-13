package nl.topicus.jgz.honeybadger.core;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSDeployment;

/**
 * Created by Thijs Smeenk on 7-8-15.
 */
public class Configuration {

	private final Container container;
	private final JAXRSDeployment jaxrsDeployment;

	protected Configuration() throws Exception {
		this.container = new Container();
		this.jaxrsDeployment = new JAXRSDeployment(this.container);
	}

	public Container getContainer() {
		return container;
	}

	public JAXRSDeployment getJaxrsDeployment() {
		return jaxrsDeployment;
	}

	public void deployJaxRS() throws Exception {
		this.container.deploy(jaxrsDeployment);
	}
}
