package org.inmar.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

  @Configuration
  @EnableWebSecurity
  public class SpringSecurityConfig extends  WebSecurityConfigurerAdapter {
 
	  
	  @Override
	    protected void configure(HttpSecurity http) throws Exception 
	    {
	        http
	         .csrf().disable()
	         .authorizeRequests().anyRequest().authenticated()
	         .and()
	         .httpBasic();
	    }
	  
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	            throws Exception 
	    {
			/*
			 * auth.inMemoryAuthentication() .withUser("admin") .password("password")
			 * .roles("USER");
			 */
	        auth.inMemoryAuthentication()
	          .withUser("user1").password(passwordEncoder().encode("user1Pass"))
	          .roles("ADMIN");
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
  // Authentication : set user/password details and mention the role protected
	/*
	 * void configure(AuthenticationManagerBuilder auth) throws Exception {
	 * auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.
	 * crypto.password.NoOpPasswordEncoder.getInstance())
	 * .withUser("user").password("pass").roles("USER") .and()
	 * .withUser("admin").password("pass").roles("USER", "ADMIN"); }
	 * 
	 * // Authorization : mention which role can access which URL protected void
	 * configure(HttpSecurity http) throws Exception {
	 * http.httpBasic().and().authorizeRequests()
	 * .antMatchers("/api/v1/location").hasRole("USER")
	 * .antMatchers("/adminlogin").hasRole("ADMIN") .and()
	 * .csrf().disable().headers().frameOptions().disable(); }
	 */ }
 