package org.honeybadger.configuration.model;

/**
 * Created by Thijs Smeenk on 7-9-15.
 */
public class Property {

	private String id;

	private String service;

	private String name;

	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String key() {
		return String.format("%s.%s", service, name);
	}
}
