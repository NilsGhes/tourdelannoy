package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.Counter;

public interface CounterService {
	Counter read(long id);
	List<Counter> findAll();
	void create(Counter counter);
	void update(Counter counter);
}
