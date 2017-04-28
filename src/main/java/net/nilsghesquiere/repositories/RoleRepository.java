package net.nilsghesquiere.repositories;

import net.nilsghesquiere.entities.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
}
