package orghoneybadger.swagger.bootstrap;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import nl.topicus.jgz.honeybadger.bootstrap.Configuration;
import nl.topicus.jgz.honeybadger.bootstrap.PreDeploymentBootstrap;

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
		beanConfig.setBasePath("/");
		beanConfig.setResourcePackage("nl.topicus.jgz.honeybadger.example");
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);

	}
}
