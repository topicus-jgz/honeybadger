package nl.topicus.jgz.honeybadger.swagger.bootstrap;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import nl.topicus.jgz.honeybadger.core.Configuration;
import nl.topicus.jgz.honeybadger.core.bootstrap.PreDeploymentBootstrap;

/**
 * Created by rickt on 18-Aug-15.
 */
public class SwaggerBootstrap implements PreDeploymentBootstrap {

	public void bootstrap(Configuration configuration) {
		configuration.getJaxrsArchive().addResource(SwaggerSerializers.class);
		configuration.getJaxrsArchive().addResource(ApiListingResource.class);

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/rest");
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);
	}
}
