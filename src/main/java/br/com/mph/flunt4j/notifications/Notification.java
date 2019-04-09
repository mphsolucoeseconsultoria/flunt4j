package br.com.mph.flunt4j.notifications;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a notification about a property validation
 * @author Ruben
 *
 */
public final class Notification {
	
	private String property;
	private String message;
	private String alias;
	
	public Notification(String property, String message) {
		super();
		this.property = property;
		this.message = message;
	}

	public String getProperty() {
		return property;
	}

	public String getMessage() {
		return message;
	}
	
	public void setAlias(String value){
		this.alias = value;
	}

	@Override
	public String toString() {
		String alias = this.alias != null ? this.alias : StringUtils.EMPTY; 
		return String.format("[ %s"  + property + "] " + message, alias);
	}
	
}
