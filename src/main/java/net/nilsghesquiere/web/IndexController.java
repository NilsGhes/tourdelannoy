package net.nilsghesquiere.web;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import net.nilsghesquiere.entities.Counter;
import net.nilsghesquiere.entities.Role;
import net.nilsghesquiere.entities.User;
import net.nilsghesquiere.services.CounterService;
import net.nilsghesquiere.services.RoleService;
import net.nilsghesquiere.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger logger = Logger.getLogger(IndexController.class.getSimpleName());
	private static final String VIEW = "index";
	private static final String REDIRECT_TO_INDEX = "redirect:/";
	
	//services
	private final CounterService counterService;
	private final RoleService roleService;
	private final UserService userService;
	
	//datum instellingen
	static ZoneId zone = ZoneId.of("Europe/Paris");

	@Autowired
	public IndexController(CounterService counterService,RoleService roleService, UserService userService) {
		this.counterService = counterService;
		this.roleService = roleService;
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView index() {
		logger.info("Index requested");
		return new ModelAndView(VIEW);
		//return new ModelAndView(VIEW).addObject(counterService.read(0));
	}
	
	@RequestMapping("/initialize.html")
	ModelAndView initialize() {
		Role role = new Role("appadmin");
		roleService.create(role);
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		User user = new User("tourdelannoy","Adm1234",roles);
		userService.create(user);
		Counter counter = new Counter("tourdelannoy",null,Duration.ofHours(3L),false);
		counterService.create(counter);
		return new ModelAndView(VIEW);
	}
	
	@PreAuthorize("hasAuthority('appadmin')")
	@RequestMapping("/start.html")
	ModelAndView start() {
		ZonedDateTime timeNow = ZonedDateTime.now(zone);
		Counter counter = counterService.read(0);
		counter.setActive(true);
		counter.setTimeStart(timeNow);
		counterService.update(counter);
		logger.info("Timer started");
		return new ModelAndView(REDIRECT_TO_INDEX);
	}
	
	@PreAuthorize("hasAuthority('appadmin')")
	@RequestMapping("/reset.html")
	ModelAndView reset() {
		Counter counter = counterService.read(0);
		counter.setActive(false);
		counter.setTimeStart(null);
		return new ModelAndView(REDIRECT_TO_INDEX);
	}
	
	// Login form
	@RequestMapping("/login.html")
	public String login() {
		return "login";
	}

	// Login form with error
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
	
}