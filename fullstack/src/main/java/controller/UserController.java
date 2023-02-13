package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proje.fullstack.Entities.c.User;
import com.Proje.fullstack.repos.UserRepository;
import com.Proje.fullstack.services.UserServices;
@RestController
@RequestMapping("/users")
public class UserController {

	private UserServices userServices;
	
	public UserController(UserServices userServices)
	{
		this.userServices=userServices;
	}
	@GetMapping
	public List<User> getAllUsers(){
		return UserServices.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser)
	{
		return UserServices.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId)
	{
		return UserServices.getOneUser(userId);
	}
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		return userServices.updateOneUser(userId,newUser);
				
	}
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userServices.deleteById(userId);
	}
}
