package com.example.config;

import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Created by bangae1 on 2016-07-05.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsersService usersService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(new ShaPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().antMatchers("/").permitAll().and()
                .csrf().and().formLogin().loginPage("/").passwordParameter("password").usernameParameter("id")
                .loginProcessingUrl("/loginProcess").permitAll().defaultSuccessUrl("/main").failureUrl("/loginFIled").permitAll()
                .and().logout().deleteCookies("JSESSIONID").logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll()
                .and().rememberMe().tokenValiditySeconds(1209600).rememberMeParameter("remember-me").key("uniqueAndSecret");

    }
}
