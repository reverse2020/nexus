package com.nexus.persistence.entity;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
public class Location {

	private double latitude;
	private double longitude;

}
