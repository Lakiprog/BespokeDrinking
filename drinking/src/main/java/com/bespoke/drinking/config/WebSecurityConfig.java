package com.bespoke.drinking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.bespoke.drinking.security.RestAuthenticationEntryPoint;
import com.bespoke.drinking.security.TokenAuthenticationFilter;
import com.bespoke.drinking.security.TokenUtils;
import com.bespoke.drinking.service.serviceImpl.CustomUserDetailsService;
import com.bespoke.drinking.utils.Constants;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder);
	}
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	private TokenUtils tokenUtils;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
			.authorizeRequests()
			
			// auth
			.antMatchers("/auth/login").permitAll()
			
			// drink
			.antMatchers(HttpMethod.GET, "/drink").hasAnyAuthority(Constants.ROLE_ADMIN, Constants.ROLE_USER)
			.antMatchers("/drink/getBestDrinks/{userId}").hasAuthority(Constants.ROLE_USER)
			.antMatchers("/drink/searchAndFilter").hasAnyAuthority(Constants.ROLE_ADMIN, Constants.ROLE_USER)
			
			// question
			.antMatchers("/question/addAnsweredQuestion/{userId}").hasAuthority(Constants.ROLE_USER)
			.antMatchers("/question/createNewQuestion").hasAuthority(Constants.ROLE_ADMIN)
			
			// restaurant
			.antMatchers(HttpMethod.GET, "/restaurant").hasAnyAuthority(Constants.ROLE_ADMIN, Constants.ROLE_USER)
			.antMatchers(HttpMethod.POST, "/restaurant").hasAuthority(Constants.ROLE_ADMIN)
			.antMatchers(HttpMethod.PUT, "/restaurant/{id}").hasAuthority(Constants.ROLE_ADMIN)
			.antMatchers("/restaurant/getBestRestaurant").hasAuthority(Constants.ROLE_USER)
			.antMatchers("/restaurant/searchAndFilter").hasAnyAuthority(Constants.ROLE_ADMIN, Constants.ROLE_USER)
			
			 // user
			.antMatchers(HttpMethod.POST, "/user").permitAll()
			.antMatchers(HttpMethod.GET, "/user/{id}").permitAll()
			.antMatchers(HttpMethod.GET, "/user").hasAuthority(Constants.ROLE_ADMIN)
			.antMatchers(HttpMethod.PUT, "/user/{id}").hasAuthority(Constants.ROLE_USER)
			
			.anyRequest().authenticated().and()
			.cors().and()
			.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, customUserDetailsService), BasicAuthenticationFilter.class);
		http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");
		web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "favicon.ico", "/**/*.html",
				"/**/*.css", "/**/*.js");
	}
}