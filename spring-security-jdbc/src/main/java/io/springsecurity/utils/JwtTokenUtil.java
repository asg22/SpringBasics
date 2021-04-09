package io.springsecurity.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwtParser;
import io.springsecurity.dao.model.MyUserDetails;

@Component
public class JwtTokenUtil implements Serializable {
	private static Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
	private String SECRET_KEY = "secret";
	/**
	 *
	 * @param httpRequest
	 * @return
	 */
	public String getTokenFromRequest(HttpServletRequest httpRequest) {
		final String requestTokenHeader = httpRequest.getHeader("Authorization");
		if (!StringUtils.isEmpty(requestTokenHeader)) {
			if (requestTokenHeader.startsWith("Bearer ")) {
				return requestTokenHeader.substring(7);
			}
		}
		return null;
	}

	/**
	 *
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {
		try {
			Jwt jwtToken = JwtHelper.decode(token);
			String claims = jwtToken.getClaims();
			HashMap claimsMap = new ObjectMapper().readValue(claims, HashMap.class);
			return claimsMap.get("user_name").toString();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 *
	 * @param token
	 * @return
	 */
	public Long getIdFromToken(String token) {
		try {
			Jwt jwtToken = JwtHelper.decode(token);
			String claims = jwtToken.getClaims();
			HashMap claimsMap = new ObjectMapper().readValue(claims, HashMap.class);
			String id = claimsMap.get("jti").toString();
			if (!StringUtils.isEmpty(id)) {
				return Long.valueOf(id);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 *
	 * @param token
	 * @return
	 */
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	/**
	 *
	 * @param token
	 * @return
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 *
	 * @param token
	 * @param claimsResolver
	 * @param <T>
	 * @return
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 *
	 * @param token
	 * @return
	 */
	private Claims getAllClaimsFromToken(String token) {
		String[] splitToken = token.split("\\.");
		String unsignedToken = splitToken[0] + "." + splitToken[1] + ".";
		DefaultJwtParser parser = new DefaultJwtParser();
		io.jsonwebtoken.Jwt jwt = parser.parse(unsignedToken);
		System.out.println(jwt.getBody());
		return (Claims) jwt.getBody();
	}

	/**
	 *
	 * @param token
	 * @return
	 */
	public boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	/**
	 *
	 * @param token
	 * @param userDetails
	 * @return
	 */
	public boolean validateToken(String token, UserDetails userDetails) {
		boolean isTokenExpired = isTokenExpired(token);
		if (!isTokenExpired) {
			final String username = getUsernameFromToken(token);
			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
		}
		return true;
	}

	/**
	 *
	 * @param token
	 * @param id
	 * @return
	 */
	public boolean isValidId(String token, Long id) {
		try {
			boolean isTokenExpired = isTokenExpired(token);
			if (!isTokenExpired) {
				Long tokenId = getIdFromToken(token);
				return id.equals(tokenId);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	private boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private boolean ignoreTokenExpiration(String token) {
		// here you specify tokens, for that the expiration is ignored
		return false;
	}
	 public String generateToken(MyUserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        Long id = (long) userDetails.getId();
	        return createToken(claims, id);
	    }
	  private String createToken(Map<String, Object> claims, Long subject) {

	        return Jwts.builder().setClaims(claims).setId(subject.toString()).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	    }
	  
	  public static void main(String[] args) {
		JwtTokenUtil j = new JwtTokenUtil();
		j.getAllClaimsFromToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWFkZXVzLmNvbSIsInJvbGUiOiJCSSxST0xFX0JJIiwiaXNzIjoiNTllZjVlZjBhNTM1MTBhYzQ2NThhNGYwMGM2MTVmYWIwMDE1ZmZiYmZiMWViNmI3MmQzYjBjNzRiNTJiMWMyMy5hcHBzLnRyYXZlbGNsaWNrLmVtYyIsImV4cCI6MTYxNzEwNDExNSwiaWF0IjoxNjE3MTAwNTE1LCJqdGkiOiJmZjI0ZWM3NC0wMTZlLTQxOWMtYmE5Yy01NGEwMjU2N2VlN2UifQ.8M6P50sQY9GK6GZHA_KC1fBlvjJ1aU-HDFkQUi-gC5Q.6a3f736e8cd6756a92bc69fba050aa10662b126d689a4e4b");
	}
}
