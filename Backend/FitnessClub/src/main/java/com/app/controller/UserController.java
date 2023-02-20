package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginResponse;
import com.app.pojos.Manager;
import com.app.pojos.Member;
import com.app.pojos.Role;
import com.app.pojos.Trainer;
import com.app.pojos.User;
import com.app.service.IManagerService;
import com.app.service.IMemberService;
import com.app.service.ITrainerService;
import com.app.service.IUserService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController 
{

	@Autowired
	IUserService ii;
	
	@Autowired
	private IManagerService mm;
	
	@Autowired
	  private ITrainerService imas;
	@Autowired
	  private IMemberService ms;
	
	public UserController() 
	{
		System.out.println("In constructor of " + getClass());
	}
	
	@PostMapping("/sigin")
	public LoginResponse<?> validateUser(@RequestBody User u)
	{
		User o =ii.validate(u);
		if(o.getRole()==Role.MANAGER)
		{
			Manager man = mm.findByUserId(o);
			return new LoginResponse<>(HttpStatus.OK,"user found ",man,man.getRole());
		}
		if(o.getRole()==Role.TRAINER)
		{
			Trainer man = imas.findByUserId(o);
			return new LoginResponse<>(HttpStatus.OK,"user found ",man,man.getRole());
		}
		
		if(o.getRole()==Role.MEMBER)
		{
			Member man = ms.findByUserId(o);
			return new LoginResponse<>(HttpStatus.OK,"user found ",man,man.getRole());
		}
		return null;
	}
	
	
	
//	@GetMapping("/members")
//	public ResponseDTO<?> getAllMembers() {
//		System.out.println("in get all Members");
//		return new ResponseDTO<>(HttpStatus.OK,"Users Found ",userService.getAllMembers());
//	}
//
//	@GetMapping("/trainers")
//	public ResponseDTO<?> getAllTrainers() {
//		System.out.println("in get all Trainers");
//		return new ResponseDTO<>(HttpStatus.OK,"Trainers found",userService.getAllTrainers());
//	}
//
//	@GetMapping("/localadmins")
//	public ResponseDTO<?> getAllLocalAdmins() {
//		System.out.println("in get all LocalAdmins");
//		return new ResponseDTO<>(HttpStatus.OK,"Local-Admins found",userService.getAllLocalAdmins());
//	}
//
//	@GetMapping("/user/{id}")
//	public ResponseEntity<?> getUser(@PathVariable int id) {
//		System.out.println("In get User details " + id);
//		return new ResponseEntity<>(userService.getUserDetails(id), HttpStatus.OK);
//	}
//
//	@PostMapping("/add/{userBranchId}")
//	public ResponseDTO<?> addUser(@RequestBody User u,@PathVariable int userBranchId) {
//		System.out.println("in Add users" + u + " userBranchId "+ userBranchId);
//		User newUser = userService.register(u,userBranchId);
//		return new ResponseDTO<>(HttpStatus.OK, "User Added Successfully", newUser);
//	}
//	
//	@PostMapping("/add")
//	public ResponseDTO<?> addUser(@RequestBody User u) {
//		System.out.println("in Add users" + u );
//		User newUser = userService.register(u);
//		return new ResponseDTO<>(HttpStatus.OK, "User Added Successfully", newUser);
//	}
/////////////////////////////////////////////////////
//	@PutMapping("/update/{id}")
//	public ResponseDTO<?> updateUser(@RequestBody User u,@PathVariable int id) {
//		System.out.println("In update user" + u+ " id "+id);
//		
//		User user = userService.updateUser(u,id);
//		return new ResponseDTO<>(HttpStatus.OK, "user updated successfully", user);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ResponseDTO<?> deleteUser(@PathVariable int id) {
//		System.out.println("in delete user " + id);
//		String deleteUser = userService.deleteUser(id);
//		return new ResponseDTO<>(HttpStatus.OK, "User deleted successfully", deleteUser);
//	}
//	
//	//@SuppressWarnings("unused")
//	@PostMapping("/signin")
//	public LoginResponse<?> authenticateUser(@RequestBody LoginRequest request){
//		System.out.println("in user authentication "+request);
//		
//		User user = userService.authenticateUserLogin(request);
//		if(user != null) {
//		UserRole role=user.getRole();
//		System.out.println("User "+user+ " "+" Role "+role);
////		return new LoginResponse<>(HttpStatus.OK,"user found ",user,role);
//		
//		
//            return new LoginResponse<>(HttpStatus.OK,"user found ",user,role);
//        }else {
//            return new LoginResponse<>(HttpStatus.NOT_FOUND,"user not found",null,null);
//        	
//        }
//		
//	}
//	
//	@PostMapping("/usersbyid/{id}")
//	public ResponseDTO<?> getUsersByBranchId(@RequestBody User u,@PathVariable int id){
//		System.out.println("In get Users by branch id "+id+ "Role "+u.getRole());
//		List<User> users=userService.getUserByBranchId(u.getRole(), id);
//		return new ResponseDTO<>(HttpStatus.OK,"All users of the branch id "+id ,users);
//		
		

//	@GetMapping("/branchmembers/{id}")
//	public ResponseDTO<?>getMyBranchUsers(@RequestBody User u,@PathVariable int id){
//		System.out.println("In MyBranch Users "+u + " id "+id);
//		List<User> users=userService.getMyBranchUsers(u.)
//		return null;
//	}
	
}


