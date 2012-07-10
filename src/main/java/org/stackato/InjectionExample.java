package org.stackato;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InjectionExample implements Serializable {

	private String properties;

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void initialize() {
		if (em == null) {
			properties = "No Entity Manager!";
			return;
		}
		if (em.getProperties() == null) {
			properties = "No properties!";
			return;
		}
		if (em.getProperties().values() == null) {
			properties = "No properties!";
			return;
		}

		String version = (String) em.createNativeQuery("SELECT VERSION();")
				.getResultList().get(0);
		String database = (String) em.createNativeQuery("SELECT DATABASE();")
				.getResultList().get(0);
		String user = (String) em.createNativeQuery("SELECT CURRENT_USER();")
				.getResultList().get(0);

		properties = "You are connected on the database \"" + database
				+ "\" as the user \""+user+"\" (Mysql version: " + version + ")";

	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

}
