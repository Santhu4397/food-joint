package com.ty.foodjoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodjoint.dto.Login;
import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.service.UserService;
import com.ty.foodjoint.util.ResponseStructure;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("this API used to add,delete,update,get user")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("user/login")
	@ApiOperation("To User Login")
	@ApiResponses({ @ApiResponse(code = 200, message = "Owner Loged In"),
			@ApiResponse(code = 404, message = " Didnot Find"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<User>> loginStaff(@ApiParam("Login for Owner") @RequestBody Login dto) {
		String email = dto.getEmail();
		String password = dto.getPassword();
		System.out.println(dto.getEmail() + dto.getPassword());
		return service.validateUser(email, password);
	}

	@PostMapping("user")
	@ApiOperation("tosave data of user in DB")
	@ApiResponses({ @ApiResponse(code = 200, message = "data saved to DB"),
			@ApiResponse(code = 404, message = "class not found in controller"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.save(user);
	}

	@GetMapping("user")
	@ApiOperation("togetall user data from DB")
	@ApiResponses({ @ApiResponse(code = 200, message = "data save to DB"),
			@ApiResponse(code = 404, message = "class not found in controller"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<List<User>>> getall() {
		return service.getall();
	}

	@DeleteMapping("user")
	@ApiOperation("todelete data of user in DB")
	@ApiResponses({ @ApiResponse(code = 200, message = "data save to DB"),
			@ApiResponse(code = 404, message = "class not found in controller"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return service.delete(id);
	}

	@GetMapping("user/{id}")
	@ApiOperation(" to getdata of user by ID  from DB")
	@ApiResponses({ @ApiResponse(code = 200, message = "data save to DB"),
			@ApiResponse(code = 404, message = "class not found in controller"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<User>> getbyid(@PathVariable int id) {
		return service.getbyid(id);
	}

	@PutMapping("user/{id}")
	@ApiOperation("update User by ID in DB")
	@ApiResponses({ @ApiResponse(code = 200, message = "data save to DB"),
			@ApiResponse(code = 404, message = "class not found in controller"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<User>> update(@PathVariable int id, @RequestBody User u) {

		return service.update(id, u);
	}
}
