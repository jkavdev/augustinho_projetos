package br.com.jkavdev.wpattern.mutrack.simple.utils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//Toda informação será convertida em JSon

@CrossOrigin(origins = "*")
@RequestMapping(consumes = "application/json", produces = "application/json")
public interface ServiceMap {

}
