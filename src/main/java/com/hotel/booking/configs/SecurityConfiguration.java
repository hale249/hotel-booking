package com.hotel.booking.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/resources/static/**/*").permitAll()
//                .antMatchers("/admin").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/admin").hasAnyRole("USER", "ADMIN").antMatchers("/admin/users")
//                .hasAnyRole("ADMIN").anyRequest().authenticated()
//                .and().formLogin().loginPage("/admin/login").permitAll()
//                .and().logout().permitAll();
//
//        http.csrf().disable();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//        authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_USER").and()
//                .withUser("javainuse").password("javainuse").authorities("ROLE_USER", "ROLE_ADMIN");
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
    }
}