package com.harbinger.cmad;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController
@CrossOrigin
@EnableSwagger2
public class UserController {
	
	@Autowired 
	private UserRepository repo;
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> add(@RequestBody User usr) { 
		repo.save(usr);
		return new ResponseEntity<User>(usr, HttpStatus.CREATED);
	}
	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public ResponseEntity <List<User>> findAll() { 
		List<User> usrs =  repo.findAll();
		return new ResponseEntity<List<User>>(usrs, HttpStatus.OK);
	}
	@RequestMapping(path = "/user/<loginid>", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable int loginid) { 
		try {
				User usr = repo.findById(loginid).orElseThrow(()-> new Exception());
				repo.delete(usr);
				return new ResponseEntity<User>(usr, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
	}	
	/*	
	@RequestMapping(path = "/user/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@PathVariable int lid) { 
		try {
			User usr = repo.findById(id).orElseThrow(()-> new Exception());
			return new ResponseEntity<User>(usr, HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
	}	

	@RequestMapping(path = "/{ip}/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> list(@PathVariable String ip) {
		List<Event> events = repo.findByIp(ip);
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
	*/	
}
