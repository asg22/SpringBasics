package io.springsecurity.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import io.springsecurity.dao.UserDao;
import io.springsecurity.dao.model.MyUserDetails;
import io.springsecurity.dao.model.User;
import io.springsecurity.dao.model.UserPropertyModel;

@Service
public class UserService implements UserDetailsService{

	private static Logger LOG = LoggerFactory.getLogger("UserService");

	@Autowired
	private UserDao userDAO;

	public UserPropertyModel getDefaultProps(Long contactId) {
		//UserPropertyModel response = new UserPropertyModel();
		// Defaults DAO Call
		List<UserPropertyModel> defaultProps = userDAO.getDefaultProps(contactId);

		if (!CollectionUtils.isEmpty(defaultProps)) {

			/*
			 * UserPropertyModel defaultProperty = defaultProps.stream() .filter(defaultProp
			 * -> "ROLE_ADMIN".equalsIgnoreCase(defaultProp.getRoles())).findAny()
			 * .orElse(null); if(null != defaultProperty) { response = defaultProps.get(0);
			 * }
			 */

		}
		return defaultProps.get(0);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.getDetailsByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("Not found: " + username);
		}
		MyUserDetails userDetails = new MyUserDetails(user);
		
		
		
		return userDetails;
	}
}
