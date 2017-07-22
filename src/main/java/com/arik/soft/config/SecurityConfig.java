package com.arik.soft.config;

import com.arik.soft.service.JpaBasedUserDetailService;
import com.arik.soft.service.authorization.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Import({RepositoryConfig.class, AuthorizationConfig.class})
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private JpaBasedUserDetailService userDetailsService;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("arunav").password("eastuser").roles("ADMIN", "USER").and()
                .withUser("aahan").password("aahanuser").roles("USER");*/
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());

    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return authorizationService.generateHashedPassword(rawPassword.toString());
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                if ((rawPassword == null || rawPassword.length() == 0)
                 || (encodedPassword == null || encodedPassword.length() == 0)) {
                    LOGGER.warn("Empty encoded password");
                    return false;
                }
                return rawPassword.equals(encodedPassword);
            }
        };
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /*httpSecurity
                .authorizeRequests().antMatchers("/api/*").hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/view/*").hasRole("USER").and()
                .authorizeRequests().antMatchers("/console/*").hasRole("ADMIN").and()*/
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity
                .authorizeRequests()
                .antMatchers("**/view/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll();
    }
}
