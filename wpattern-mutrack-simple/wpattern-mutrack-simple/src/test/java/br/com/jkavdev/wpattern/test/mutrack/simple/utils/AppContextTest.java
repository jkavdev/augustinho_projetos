package br.com.jkavdev.wpattern.test.mutrack.simple.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.jkavdev.wpattern.mutrack.simple.utils.AppContext;
import br.com.jkavdev.wpattern.test.mutrack.simple.AbstractTest;

//Configura contexto de test e importa configurações do contexto da aplicação do spring

@Configuration
@Import(value = { AppContext.class })
@ComponentScan(basePackageClasses = { AbstractTest.class })
public abstract class AppContextTest {

}
