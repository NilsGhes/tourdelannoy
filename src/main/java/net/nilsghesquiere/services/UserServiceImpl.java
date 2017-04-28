package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.User;
import net.nilsghesquiere.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public User read(long id){
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void create(User user) {
		userRepository.save(user);
	}
}
