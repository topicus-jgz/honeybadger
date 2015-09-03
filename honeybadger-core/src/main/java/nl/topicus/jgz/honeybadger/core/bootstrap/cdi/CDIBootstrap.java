package nl.topicus.jgz.honeybadger.core.bootstrap.cdi;

/**
 * Created by Thijs Smeenk on 17-8-15.
 */
public interface CDIBootstrap<T> {

	T produce();

	void bootstrap(T target);
}