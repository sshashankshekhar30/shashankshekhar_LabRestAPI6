package com.greatlearning.lab6.student.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.lab6.student.Model.Student;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {
	
	@Autowired
	private Student student;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority>authorities = new ArrayList<>();

		
		for (Student student : student) {
            authorities.add(new SimpleGrantedAuthority(student.getFirstName()));
            authorities.add(new SimpleGrantedAuthority(student.getLastName()));
            authorities.add(new SimpleGrantedAuthority(student.getCourse()));
            authorities.add(new SimpleGrantedAuthority(student.getCountry()));
        }

        return authorities;

	}

	@Override
	public String getPassword() {
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return student.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
