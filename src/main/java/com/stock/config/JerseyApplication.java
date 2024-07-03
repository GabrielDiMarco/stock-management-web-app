package com.stock.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//@ApplicationPath("api")
public class JerseyApplication extends ResourceConfig {
	public JerseyApplication() {
		register(new ApplicationBinder());
		packages("com.stock.resources");
	}
}