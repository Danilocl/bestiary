package com.br.bestiary.util;

public enum MessangerErrorEnum {

	REPEATED("Beast already registered, please insert another Beast"),
	EMPTY("There is no registered beast"),
	NOTFOUND("Beast not found");
	
	private String messenger;

	MessangerErrorEnum(String messenger) {
		this.messenger = messenger;
	}

	public String getMessenger() {
		return messenger;
	}
}
