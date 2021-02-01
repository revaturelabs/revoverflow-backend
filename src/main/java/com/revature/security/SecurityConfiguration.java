package com.revature.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.repositories.UserRepository;
import com.revature.security.jwt.DefaultTokenManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsService clientUserDetailsService;
	private final ObjectMapper mapper;
	private final DefaultTokenManager defaultTokenManager;
	private final UserRepository userRepository;

	public SecurityConfiguration(UserDetailsService clientUserDetailsService, ObjectMapper mapper,
			DefaultTokenManager defaultTokenManager, UserRepository userRepository) {
		this.clientUserDetailsService = clientUserDetailsService;
		this.mapper = mapper;
		this.defaultTokenManager = defaultTokenManager;
		this.userRepository = userRepository;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	private CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
		config.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
		config.applyPermitDefaultValues();
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new RevOverflowAuthenticationProvider(clientUserDetailsService, passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Enable these lines of code if needing to access h2 console
//		http.authorizeRequests().antMatchers("/").permitAll();
//
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	    http
	      .cors(customizer -> {
	        customizer.configurationSource(corsConfigurationSource());
	      })
	      .csrf()
	        .disable()
	      .formLogin()
	        .disable()
	      .httpBasic()
	        .disable()
	      .anonymous()
	        .disable()
	      .authorizeRequests()
	        .mvcMatchers("/login", HttpMethod.POST.toString())
	          .permitAll()
	        .anyRequest()
	          .authenticated()
	      .and()
	      .addFilterAt(new JwtPresentFilter(defaultTokenManager, clientUserDetailsService), UsernamePasswordAuthenticationFilter.class)
	      .addFilterAfter(new LoginFilter(mapper, authenticationProvider(), defaultTokenManager, userRepository), UsernamePasswordAuthenticationFilter.class);
	}

}
