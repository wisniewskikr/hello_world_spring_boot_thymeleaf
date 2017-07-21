package pl.kwi.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery("select email, password, enabled from users where email=?")
				.authoritiesByUsernameQuery("select email, role from user_roles where email=?")
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
					.antMatchers("/", "/registration/**", "/confirmation/**", "/resetEmail/**").permitAll()
					.antMatchers("/input", "/output").access("hasRole('ROLE_ADMIN')")
					.anyRequest().authenticated()
					.and()
                .formLogin()
					.loginPage("/login")
					.usernameParameter("email")
					.passwordParameter("password")
					.permitAll()
					.and()
                .logout()
					.permitAll();
    }

}
