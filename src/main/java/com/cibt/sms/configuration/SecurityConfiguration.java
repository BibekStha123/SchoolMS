/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.configuration;

import com.cibt.sms.configuration.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Bibek
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserSecurityService userSecurityService;
    
//    @Bean
//    public DriverManagerDataSource getDataSource(){
//        DriverManagerDataSource dataSource = 
//                new DriverManagerDataSource("jdbc:mysql://localhost/cibt_project");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(getPasswordEncoder())
//                .withUser("admin")
//                .password(getPasswordEncoder().encode("admin123"))
//                .authorities("ROLE_ADMIN");
        
//           auth.jdbcAuthentication() //without using UserDetailsService
//            .authoritiesByUsernameQuery("select username, role from tbl_users u"
//                    + " join tbl_user_roles ur on u.id=ur.user_id "
//                    + "join tbl_roles r on r.id=ur.role_id "
//                    + "where username=?")
//            .usersByUsernameQuery("SELECT username, password, status FROM tbl_users WHERE username=?")
//            .passwordEncoder(getPasswordEncoder())
//            .dataSource(getDataSource());
        
        auth.authenticationProvider(getAuthProvider());
                
    }
    
    @Bean
    protected DaoAuthenticationProvider getAuthProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getPasswordEncoder());
        provider.setUserDetailsService(userSecurityService);
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
             .anyRequest()
             .authenticated()
             .and()
             .formLogin().loginPage("/login").permitAll()
             .and()
             .logout().permitAll().invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**");
    }
    
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
