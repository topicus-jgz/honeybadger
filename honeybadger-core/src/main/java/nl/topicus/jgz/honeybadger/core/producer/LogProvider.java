package nl.topicus.jgz.honeybadger.core.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Thijs Smeenk on 17-8-15.
 */
public class LogProvider {

	@Produces
	public Logger createLogger(InjectionPoint ip) {
		return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
	}
}


