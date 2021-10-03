package com.demo.mvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.mvc.dao.AppUsersDaoImpl;
import com.demo.mvc.model.AppUser;

@Service("DBUDService")	
public class DBUserDetailsService implements UserDetailsService {

	@Autowired
	AppUsersDaoImpl appuserDao;
	
	public AppUsersDaoImpl getAppuserDao() {
		return appuserDao;
	}

	public void setAppuserDao(AppUsersDaoImpl appuserDao) {
		this.appuserDao = appuserDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appuserDao.findByUsername(username);
		List<GrantedAuthority> authorities = buildAppUserAuthority(appUser);
		return buildAppUserForAuthentication(appUser, authorities);
	}

	private List<GrantedAuthority> buildAppUserAuthority(AppUser appUser) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		if (appUser != null & !StringUtils.isEmpty(appUser.getUsername())) {
			String rolecsv = appUser.getRole();
			if(!StringUtils.isEmpty(rolecsv)) {
				String[] roleArr = rolecsv.split(",");
				for (String eachRole : roleArr) {
					setAuths.add(new SimpleGrantedAuthority(eachRole));
				}
			}
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

	private User buildAppUserForAuthentication(AppUser appuser, List<GrantedAuthority> authorities) {
		return new User(appuser.getUsername(), appuser.getPassword(), true, true, true, true, authorities);
	}

}
