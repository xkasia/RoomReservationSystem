package pl.hit.system.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
//public class SecurityConfig{
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

//        http.authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers("/login").anonymous()
//                .antMatchers("/logout").authenticated()
//                .antMatchers("/register").anonymous()
//                .antMatchers("/user", "/user/**","/reservation", "/reservation/**").hasRole("USER")
//                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                .failureUrl("/home/login.html?error=true")
//                .and()
//                .csrf().disable()
//                .logout()
//                .logoutSuccessUrl("/home")
                ;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    { return new BCryptPasswordEncoder(); }

    private DataSource dataSource() {
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("org.h2.Driver");
        dm.setUrl("jdbc:h2:mem:testdb");
        dm.setUsername("sa");
        dm.setPassword("");
        return dm;
    }
}

