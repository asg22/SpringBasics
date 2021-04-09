package io.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springsecurity.dao.model.AuthenticationRequest;
import io.springsecurity.dao.model.AuthenticationResponse;
import io.springsecurity.dao.model.MyUserDetails;
import io.springsecurity.dao.model.UserPropertyModel;
import io.springsecurity.security.JwtUtils;
import io.springsecurity.service.UserService;
import io.springsecurity.utils.JwtTokenUtil;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtTokenUtil;
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	//@CrossOrigin
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
	HttpHeaders responseHeaders = new HttpHeaders();
		
	Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		//if authentication was succesful else throw an exception
		final MyUserDetails userDetails = (MyUserDetails) userService
			.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateJwtToken(authenticate);
		AuthenticationResponse response = new AuthenticationResponse(jwt);

		response.setId(userDetails.getId());
		response.setUsername(userDetails.getUsername());
		List<String> roles = new ArrayList<String>();
		userDetails.getAuthorities().forEach((a) -> roles.add(a.getAuthority()));
		response.setRoles(roles);

		return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
	
	}
	//@PreAuthorize("@methodAuthentication.validateContactId(#contactId)")
    @GetMapping(path="/hello/{contactId}")
    public ResponseEntity<UserPropertyModel> defaultProps(@PathVariable Long contactId) {
        UserPropertyModel result = userService.getDefaultProps(contactId);
        if (null != result) {
            return new ResponseEntity<UserPropertyModel>(result, HttpStatus.OK);
        }
        return new ResponseEntity<UserPropertyModel>(HttpStatus.NO_CONTENT);
    }
	
}
