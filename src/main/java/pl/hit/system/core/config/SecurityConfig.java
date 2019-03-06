package pl.hit.system.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource())
                .usersByUsernameQuery("SELECT login, password, true FROM users WHERE login = ?")
                .authoritiesByUsernameQuery("SELECT login, role FROM users_roles WHERE login = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/login").anonymous()
                .antMatchers("/logout").authenticated()
                .antMatchers("/register").anonymous()
                .antMatchers("/user", "/user/**","/reservation", "/reservation/**").hasRole("USER")
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .csrf().disable()
                .logout()
                .logoutSuccessUrl("/home")
                ;
    }

    private DataSource dataSource() {
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("org.h2.Driver");
        dm.setUrl("jdbc:h2:mem:testdb");
        dm.setUsername("sa");
        dm.setPassword("");
        return dm;
    }
}

