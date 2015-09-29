package org.honeybadger.bootstrap;

import org.jboss.shrinkwrap.api.asset.StringAsset;

/**
 * //todo move to examples
 * <p>
 * Created by Thijs Smeenk on 14-8-15.
 */
public class CDIBootstrapper implements PreDeploymentBootstrap {

	public void bootstrap(Configuration configuration) {
		configuration.getJaxrsArchive().addAsWebInfResource(
		 new StringAsset("<beans xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
						 "    xsi:schemaLocation=\"\n" +
						 "        http://xmlns.jcp.org/xml/ns/javaee\n" +
						 "        http://xmlns.jcp.org/xml/ns/javaee/beans_1_1.xsd\" bean-discovery-mode=\"all\">\n" +
						 "</beans>"), "beans.xml");
	}
}
