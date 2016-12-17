package br.com.jkavdev.wpattern.test.mutrack.simple;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jkavdev.wpattern.test.mutrack.simple.utils.AppContextTest;

//Configura Spring com JUnit

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppContextTest.class)
public class AbstractTest {

}
