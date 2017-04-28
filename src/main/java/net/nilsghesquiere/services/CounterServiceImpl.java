package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.Counter;
import net.nilsghesquiere.repositories.CounterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class CounterServiceImpl implements CounterService{
	private final CounterRepository counterRepository;
	
	@Autowired
	public CounterServiceImpl(CounterRepository counterRepository){
		this.counterRepository = counterRepository;
	}
	
	public Counter read(long id){
		return counterRepository.findOne(id);
	}

	@Override
	public List<Counter> findAll() {
		return (List<Counter>) counterRepository.findAll();
	}

	@Override
	public void create(Counter counter) {
		counterRepository.save(counter);
	}

	@Override
	public void update(Counter counter) {
		counterRepository.save(counter);
	}
}
