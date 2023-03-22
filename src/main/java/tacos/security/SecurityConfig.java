package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.formLogin()
			.loginPage("/login")
			.and()
			.logout()
			.logoutSuccessUrl("/");
		
		http.authorizeHttpRequests(authorize -> authorize
	        	.requestMatchers("/design", "/orders").hasRole("ROLE_USER")
	        	.requestMatchers("/**").permitAll()
       	);
		
		http.csrf().disable();
		
		return http.build();
	}
}
