package br.com.jkavdev.wpattern.mutrack.simple.utils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.jkavdev.wpattern.mutrack.simple.AppMain;

//Classe de configuração do contexto do Spring

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { AppMain.class })
public class AppContext {

}
