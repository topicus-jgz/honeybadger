package nl.topicus.jgz.honeybadger.core.producer;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
/**
 * Created by Thijs Smeenk on 17-8-15.
 */
	public class LogProvider {
		@Produces
		public Logger createLogger(InjectionPoint ip) {
			return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
		}
	}


