package de.juli.newjob.recource.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Stellt Methoden zur verfuegung, mit denen REST Request-URLs anhand 
 * von URL-Ruempfen und Uebergabeparametern erzeugt und zuruekgegeben 
 * werden koennen.
 * @author ukloodt
 *
 */
public class RestRequestFormater {
	private static final Logger LOG = LoggerFactory.getLogger(RestRequestFormater.class);
	private static final PrettyLog LOG_PRETTY = new PrettyLog(LOG);
	public static final Integer DEFAULT_SERVERPORT = 8080;
	public static final String HOST = "http://localhost";
	public static final String JSON_SCHEMA = "v2/api-docs";
	public static final String VERTRAEGE = "rest/vertraege?kdNr=103238344&zgrp=2&modus=3&vermittelt=3&tiefe=4";
	private final Integer currentServerPort;
		
	public RestRequestFormater(Integer serverPort) {
		super();
		if(serverPort == null) {
			this.currentServerPort = DEFAULT_SERVERPORT;
		} else {
			this.currentServerPort = serverPort;			
		}
		LOG_PRETTY.info("You'r currently using defaul serverport", DEFAULT_SERVERPORT);
	}

	public String bulidRequestUrl() {
		return String.format("%s:%s", HOST, currentServerPort);
	}

	public String bulidRequestUrl(String path) {
        return String.format("%s:%s/%s", HOST, currentServerPort, path);
    }

	public String bulidRequestUrl(Integer port, String path) {
		return String.format("%s:%s/%s", HOST, port, path);
	}

	public Integer getCurrentServerPort() {
		return currentServerPort;
	}
}
