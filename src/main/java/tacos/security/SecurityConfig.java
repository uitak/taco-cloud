package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public PasswordEncoder encoder() {
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
	        	.requestMatchers("/design", "/orders").hasRole("USER")
				//.requestMatchers("/design", "/orders").authenticated()
	        	.requestMatchers("/**").permitAll()
       	);
		
		http.csrf().disable();
		// h2-console 페이지 표시 안될 경우 필요.
        http.headers().frameOptions().disable();
		
		return http.build();
	}
}
