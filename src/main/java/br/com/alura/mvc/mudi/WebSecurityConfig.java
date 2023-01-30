package br.com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;*/
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
/*import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;*/
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

	@Autowired 
	DataSource dataSource;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.defaultSuccessUrl("/home", true)
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());
		
		return http.build();
	}
	
	
	/* Cria usuário no banco de dados
	 * @Bean UserDetailsManager users(DataSource dataSource) {
	 * 
	 * UserDetails user = User.builder() .username("user2")
	 * .password(passwordEncoder().encode("password")) .roles("ADM") .build();
	 * 
	 * JdbcUserDetailsManager users = new JdbcUserDetailsManager(this.dataSource);
	 * users.createUser(user);
	 * 
	 * return users; }
	 */
	@Bean
    public UserDetailsManager users(DataSource dataSource) {
        
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        
        return users;
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(16);   
	}	 
	 

}