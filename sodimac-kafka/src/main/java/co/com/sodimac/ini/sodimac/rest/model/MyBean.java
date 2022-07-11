package co.com.sodimac.ini.sodimac.rest.model;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
	
	 public User response(User user) {
	        user.setName(user.getName().toUpperCase());
	        return user;
	    }

}
