package com.nexus.persistence.entity;

import javax.persistence.Embeddable;

import lombok.Data;


@Embeddable
@Data
public class Location {

	private double latitude;
	private double longitude;

}
