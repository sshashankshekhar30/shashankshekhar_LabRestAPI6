package com.greatlearning.lab6.student.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.lab6.student.Service.UserDetailsServiceImpl;

public class WebSecurityCoinfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers(HttpMethod.POST, "/Student/Home", "/Student/Home/Student-List", "/Student/Home/Stduent-Form").hasAuthority("ADMIN")
		.antMatchers("/swagger-ui.html").hasAuthority("ADMIN").anyRequest()
		.authenticated().and().httpBasic().and().formLogin().and().logout().logoutSuccessUrl("/login")
		.permitAll().and().cors().and().csrf().disable();
    }


}
