package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.User;

public interface UserService {
	User read(long id);
	List<User> findAll();
	void create(User user);
}
