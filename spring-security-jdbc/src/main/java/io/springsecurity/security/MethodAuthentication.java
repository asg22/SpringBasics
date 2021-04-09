package io.springsecurity.security;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.springsecurity.dao.UserDao;
import io.springsecurity.utils.JwtTokenUtil;

@Component
public class MethodAuthentication{
	
	private static Logger LOG = LoggerFactory.getLogger(MethodAuthentication.class); 
			
	@Autowired
    private HttpServletRequest httpRequest;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private  UserDao userDao;
    
	public boolean validateContactId(Long contactId) {
        LOG.debug("validateContactId({})", contactId);
        System.out.println("in contact");
        if (contactId != null) {
            String token = jwtTokenUtil.getTokenFromRequest(httpRequest);
            if (!jwtTokenUtil.isValidId(token, contactId)) {
                LOG.info("Unauthorized: the provided contact id {} and the token id do not match", contactId);
                return false;
            }
            return true;
        }
        return false;
    }
}
