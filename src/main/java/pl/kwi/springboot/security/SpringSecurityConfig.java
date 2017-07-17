package pl.kwi.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery("select username, password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?")
				.dataSource(dataSource);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
					.antMatchers("/", "/registration/**", "/confirmation/**").permitAll()
					.antMatchers("/input", "/output").access("hasRole('ROLE_ADMIN')")
					.anyRequest().authenticated()
					.and()
                .formLogin()
					.loginPage("/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.permitAll()
					.and()
                .logout()
					.permitAll();
    }

}
