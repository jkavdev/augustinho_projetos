package br.com.jkavdev.wpattern.test.mutrack.simple.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.simple.user.UserEntity;
import br.com.jkavdev.wpattern.mutrack.simple.user.UserRepository;
import br.com.jkavdev.wpattern.test.mutrack.simple.AbstractTest;

public class UserRepositoryTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(UserRepositoryTest.class);

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testFindAll() {
		List<UserEntity> users = this.userRepository.findAll();

		logger.info(users);
	}

	@Test
	public void testFindByEmail() {
		String email = "admin@admin.com";
		UserEntity user = this.userRepository.findByEmail(email);

		logger.info(user);
	}

	@Test
	public void testFidByEmailOrName() {
		String email = "admin@admin.com";
		String name = "user";

		List<UserEntity> users = this.userRepository.findByEmailOrName(email, name);

		logger.info(users);
	}

}
