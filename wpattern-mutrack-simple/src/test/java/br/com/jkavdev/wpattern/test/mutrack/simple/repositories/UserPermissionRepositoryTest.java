package br.com.jkavdev.wpattern.test.mutrack.simple.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.simple.userpermission.UserPermissionEntity;
import br.com.jkavdev.wpattern.mutrack.simple.userpermission.UserPermissionRepository;
import br.com.jkavdev.wpattern.test.mutrack.simple.AbstractTest;

public class UserPermissionRepositoryTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(UserPermissionRepositoryTest.class);

	@Autowired
	private UserPermissionRepository userPermissionRepository;

	@Test
	public void testFindAll() {
		List<UserPermissionEntity> userPermissions = this.userPermissionRepository.findAll();

		logger.info(userPermissions);
	}
}
