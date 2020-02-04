package com.nexus.persistence.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class User {

	@Id
	private String id;
	private String guid;
	private Boolean  isActive;
	private double balance;
	private String pictureUrl;
	private int age;
	private String eyeColor;
	private String name;
	private String gender;
	private String company;
	private String email;
	private String phone;
	@Embedded
	private Address address;
	@Embedded
	private Location location;
}
