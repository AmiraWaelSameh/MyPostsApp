package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusType {
	PUBLIC("Public"), PRIVATE("Private");

	private String value;

	private StatusType(String value) {
		this.value = value;
	}

	@JsonCreator
	public static StatusType fromString(String value) {
		if (value == null) {
			return null;
		}
		return StatusType.valueOf(value.toUpperCase());
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
