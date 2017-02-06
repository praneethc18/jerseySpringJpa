package com.jersey.spring.offline.app;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jersey.spring.dao.entity.User;
import com.jersey.spring.service.UserManagerImpl;

public class Main 
{
    public static void main( String[] args )
    {
//    	Resource resource=new ClassPathResource("spring.xml"); 
    	ClassPathXmlApplicationContext ctx =  new ClassPathXmlApplicationContext("classpath*:/spring.xml");
    	    			
    	UserManagerImpl userManager = (UserManagerImpl) ctx.getBean(UserManagerImpl.class);
    	
    	User user = new User();
    	user.setUsername("johndoe");
    	user.setName("John Doe");
    	
    	userManager.insertUser(user);
    	
    	System.out.println("User inserted!");
    	
    	user = userManager.getUser("johndoe");
    	
    	System.out.println("\nUser fetched by username!"
    		+ "\nId: " + user.getId()
    		+ "\nUsername: " + user.getUsername()
    		+ "\nName: " + user.getName());
    	
    	user = userManager.getUserById(user.getId());
    	
    	System.out.println("\nUser fetched by ID!"
    		+ "\nId: " + user.getId()
    		+ "\nUsername: " + user.getUsername()
    		+ "\nName: " + user.getName());
    	
    	List<User> users = userManager.getUsers();
    	users.forEach(
    			x->System.out.println(x.toString())
    			);
    	System.out.println("\nUser list fetched!"
        	+ "\nUser count: " + users.size());

    	ctx.close();
    }
}
