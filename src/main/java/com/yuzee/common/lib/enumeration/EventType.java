package com.yuzee.common.lib.enumeration;

public enum EventType {
	EVENT_TYPE_PUSH_NOTIFICATION("EVENT_TYPE_PUSH_NOTIFICATION"),
	EVENT_TYPE_EMAIL_NOTIFICATION("EVENT_TYPE_EMAIL_NOTIFICATION"),
	EVENT_TYPE_NOTIFICATION("EVENT_TYPE_NOTIFICATION"),
	EVENT_TYPE_EMAIL_UPDATE_REQUEST("EVENT_TYPE_EMAIL_UPDATE_REQUEST"),
	EVENT_TYPE_STORAGE_CREATED("EVENT_TYPE_STORAGE_CREATED");
	
	private String name;

	EventType(String name) {
        this.name = name;
    }
	
	public String getName() {
        return this.name;
    }
}
