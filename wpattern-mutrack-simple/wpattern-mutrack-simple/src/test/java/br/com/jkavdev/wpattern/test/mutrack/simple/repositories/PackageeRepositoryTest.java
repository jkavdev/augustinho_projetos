package br.com.jkavdev.wpattern.test.mutrack.simple.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.wpattern.mutrack.simple.packagee.PackageeEntity;
import br.com.jkavdev.wpattern.mutrack.simple.packagee.PackageeRepository;
import br.com.jkavdev.wpattern.test.mutrack.simple.AbstractTest;

public class PackageeRepositoryTest extends AbstractTest {

	private static final Logger logger = Logger.getLogger(PackageeRepositoryTest.class);

	@Autowired
	private PackageeRepository packageeRepository;

	@Test
	public void testFindAll() {
		List<PackageeEntity> packagess = this.packageeRepository.findAll();

		logger.info(packagess);
	}

}
