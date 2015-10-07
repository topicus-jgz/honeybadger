package org.honeybadger.example;

import com.google.common.collect.Lists;
import java.util.List;

import org.honeybadger.bootstrap.PreDeploymentBootstrap;
import org.honeybadger.core.Service;
import orghoneybadger.swagger.bootstrap.SwaggerBootstrap;
//import orghoneybadger.swagger.bootstrap.SwaggerBootstrap;

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
		registerResource(ExampleResource.class);
	}
}
