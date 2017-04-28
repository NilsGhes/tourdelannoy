package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.Role;

public interface RoleService {
	Role read(long id);
	List<Role> findAll();
	void create(Role role);
}
