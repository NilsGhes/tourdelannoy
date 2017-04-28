package net.nilsghesquiere.repositories;

import net.nilsghesquiere.entities.Counter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Long>{
	
}
