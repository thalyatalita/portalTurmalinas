package com.iesp.turmalinas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf()
			.disable()
				.authorizeRequests()
				.antMatchers("/evento").hasAnyRole("ADMIN")
				.antMatchers("/produtos").hasAnyRole("ADMIN")
				.antMatchers("/membros").hasAnyRole("USER")
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and().formLogin()
					.loginPage("/login").permitAll()
				.and().rememberMe()
				.and().logout()
					.logoutSuccessUrl("/login?logout");
				
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/img/**", "/scripts/**");
	}

}
