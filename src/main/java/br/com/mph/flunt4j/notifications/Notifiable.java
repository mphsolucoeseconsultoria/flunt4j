package br.com.mph.flunt4j.notifications;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.mph.mphutils.collections.CollectionFactory;

public abstract class Notifiable {

	private List<Notification> _notifications;
	
	protected Notifiable() {
		_notifications = CollectionFactory.newList();		
	}

	public List<Notification> getNotifications() {
		return Collections.unmodifiableList(_notifications);
	}
	
	public void addNotification(String property, String message){
		_notifications.add(new Notification(property, message));
	}
	
	public void addNotification(Notification notification){
		_notifications.add(notification);
	}
	
	public void addNotifications(Collection<Notification> notifications){
		_notifications.addAll(notifications);		
	}
	
	public void addNotifications(Notifiable other){
		_notifications.addAll(other._notifications);
	}
	
	public void addNotifications(Notification[] items){
		_notifications.addAll(Arrays.asList(items));
	}
	
	public boolean invalid(){
		return !_notifications.isEmpty();
	}
	
	public boolean valid(){
		return !invalid();
	}
}
