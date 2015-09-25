package nl.topicus.jgz.honeybadger.example;

import com.google.common.collect.Lists;
import io.swagger.jaxrs.config.BeanConfig;
import java.util.List;

import nl.topicus.jgz.honeybadger.bootstrap.PreDeploymentBootstrap;
import nl.topicus.jgz.honeybadger.core.Service;
import nl.topicus.jgz.honeybadger.core.jaxrs.Resource;
import nl.topicus.jgz.honeybadger.swagger.bootstrap.SwaggerBootstrap;

/**
 * Created by rickt on 03-Sep-15.
 */
public class ExampleService extends Service {

	public static void main(String[] args) {
		try {
			new ExampleService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected ExampleService() throws Exception {
		super();
	}

	@Override
	protected List<PreDeploymentBootstrap> bootstraps() {
		return Lists.newArrayList(new SwaggerBootstrap());
	}

	@Override
	public void setup() {
	}
}
