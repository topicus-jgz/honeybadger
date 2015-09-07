package nl.topicus.jgz.honeybadger.bootstrap;

import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.Datasource;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.datasources.Driver;
import org.wildfly.swarm.jpa.JPAFraction;

import nl.topicus.jgz.honeybadger.configuration.Configuration;

/**
 * //todo move to examples this it's just an example of bootstrapping datasources in an akward way
 * <p>
 * Created by Thijs Smeenk on 21-8-15.
 */
public class DSBootStrap implements PreDeploymentBootstrap {

	public void bootstrap(Configuration configuration) {

		Container container = configuration.getContainer();

		container.subsystem(new DatasourcesFraction().driver(
		 new Driver("h2").datasourceClassName("org.h2.Driver").xaDatasourceClassName("org.h2.jdbcx.JdbcDataSource")
						 .module("com.h2database.h2")).datasource(
		 new Datasource("crashboard").driver("h2").connectionURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
									 .authentication("sa", "sa")));

		// Prevent JPA Fraction from installing it's default datasource fraction
		container.fraction(new JPAFraction().inhibitDefaultDatasource().defaultDatasourceName("MyDS"));

		configuration.getJaxrsArchive()
					 .addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", DSBootStrap.class.getClassLoader()),
										  "classes/META-INF/persistence.xml");
	}
}
