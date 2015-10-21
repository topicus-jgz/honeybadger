package orghoneybadger.swagger.bootstrap;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.honeybadger.bootstrap.Configuration;
import org.honeybadger.bootstrap.PreDeploymentBootstrap;

/**
 * Created by rickt on 18-Aug-15.
 */
@Startup
@Singleton
public class SwaggerBootstrap {

	public SwaggerBootstrap() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8092");
		beanConfig.setBasePath("/");
		beanConfig.setResourcePackage("org.honeybadger.example");
		beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);
	}
}
