package org.honeybadger.bootstrap;

import org.wildfly.swarm.container.Container;

/**
 * //todo move to examples this it's just an example of bootstrapping datasources in an akward way
 * <p>
 * Created by Thijs Smeenk on 21-8-15.
 */
public class DSBootStrap implements PreDeploymentBootstrap {

	public void bootstrap(Configuration configuration) {

		Container container = configuration.getContainer();

/*		// and a datasource
		container.subsystem(new DatasourcesFraction().jdbcDriver(
		 new JdbcDriver("h2").driverDatasourceClassName("org.h2.Driver").xaDatasourceClass("org.h2.jdbcx.JdbcDataSource")
							 .driverModuleName("com.h2database.h2")).dataSource(
		 new DataSource("ExampleDS").driverName("h2").connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
									.userName("sa").password("sa")));*/
	}
}
