package com.nexus.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexus.persistence.entity.User;
import com.nexus.persistence.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class DataLoader {


	@Autowired
	private UserRepo userRepo;

	@PostConstruct
	private void loadUsers() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/bootstrap.json");
		try {
			List<User> users = mapper.readValue(inputStream, typeReference);
			log.info("Saving users...");
			userRepo.saveAll(users);
			log.info(users.size() + " Users Saved...");
		} catch (IOException e) {
			log.error("Unable to save users: " + e.getMessage());
		}

	}
}