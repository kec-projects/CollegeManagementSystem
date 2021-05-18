package com.collegemanagementsystem.Config;

import com.collegemanagementsystem.Handler.entryPointHandler;
import com.collegemanagementsystem.Handler.logoutHandler;
import com.collegemanagementsystem.Handler.successHandler;
import com.collegemanagementsystem.Handler.failureHandler;
import com.collegemanagementsystem.Service.interfaceClass.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private entryPointHandler entryPointHandler;
    @Autowired
    private successHandler successHandler;
    @Autowired
    private failureHandler failureHandler;
    @Autowired
    private logoutHandler logoutHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().permitAll();
        //http.csrf().disable();
        http.authorizeRequests().antMatchers("/users/registration").permitAll();
        http.authorizeRequests().antMatchers("/users/*").authenticated();
        http.csrf().disable();
       http.exceptionHandling().authenticationEntryPoint(entryPointHandler);
        http.formLogin().successHandler(successHandler);
        http.formLogin().failureHandler(failureHandler);
        http.logout().addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
                //.logoutSuccessUrl("/users/logout")
                .permitAll();


    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}
