package br.com.jkavdev.wpattern.test.mutrack.simple.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.simple.permission.PermissionEntity;
import br.com.jkavdev.wpattern.mutrack.simple.permission.PermissionRepository;
import br.com.jkavdev.wpattern.test.mutrack.simple.AbstractTest;

public class PermissionRepositoryTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(PermissionRepositoryTest.class);

	@Autowired
	private PermissionRepository permissionRepository;

	@Test
	public void testFindAll() {
		List<PermissionEntity> permissions = this.permissionRepository.findAll();

		logger.info(permissions);
	}
}
