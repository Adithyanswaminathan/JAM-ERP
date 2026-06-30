package com.tatastrive.erp.JAM.Enterprises.config;

import java.util.Map;

import com.tatastrive.erp.JAM.Enterprises.Entity.AppUser;
import com.tatastrive.erp.JAM.Enterprises.Repository.AppUserRepository;
import com.tatastrive.erp.JAM.Enterprises.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	JwtService jwtService;
	@Autowired
	private AppUserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/login")
	public String login(@RequestBody Map<String, String> request)
	{
		String username  = request.get("email");
		String password = request.get("password");
		
		Authentication authentication= authManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		
		if(authentication.isAuthenticated())
		{
			return jwtService.generateToken(username);
		}
		
		
		return "login failed";
	}
	
	
	@PostMapping("/register")
	public String register(@RequestBody Map<String, String> request)
	{
		
		AppUser newUser = new AppUser();
		newUser.setEmail(request.get("email"));
		newUser.setPassword(passwordEncoder.encode(request.get("password")) );
		newUser.setRole( Role.valueOf(request.get("role")) );
		userRepo.save(newUser);
		return "register  successfuly";
	}

}
