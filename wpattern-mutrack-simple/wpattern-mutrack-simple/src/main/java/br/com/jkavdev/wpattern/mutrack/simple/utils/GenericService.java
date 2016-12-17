package br.com.jkavdev.wpattern.mutrack.simple.utils;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class GenericService<T extends BaseEntity<ID>, ID extends Serializable> implements ServiceMap {

	private final Logger logger = Logger.getLogger(getClass());

	// Instânciará o repositório da dada entidade em tempo de execução
	@Autowired
	protected JpaRepository<T, ID> genericRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> findAll() {
		logger.info("Requisitando todos os registros!");

		return this.genericRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public T insert(@RequestBody T entity) {
		logger.info(String.format("Salvando a entidade [%s],", entity));
		
		entity.setId(null);

		return this.genericRepository.save(entity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public T update(@RequestBody T entity) {
		logger.info(String.format("Atualizando a entidade [%s],", entity));
		
		if(entity.getId() == null){
			this.logger.error("O ID não pode estar vazio");
			return null;
		}
		
		return this.genericRepository.save(entity);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody T entity) {
		logger.info(String.format("Deletando a entidade [%s],", entity));
		this.genericRepository.delete(entity);
	}

}
