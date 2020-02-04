package com.nexus.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexus.persistence.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DataLoader {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private UserRepo userRepo;

}