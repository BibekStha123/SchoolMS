/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.configuration.service;

import com.cibt.sms.entity.User;
import com.cibt.sms.entity.UserRole;
import com.cibt.sms.repository.UserRepository;
import com.cibt.sms.repository.UserRoleRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bibek
 */
@Service
public class UserSecurityService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException(userName);
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User
                                  (userName, user.getPassword(), getAuthorities(userName));
    
        return userDetails;
    }
    
    public  Collection<? extends GrantedAuthority> getAuthorities(String userName){
       List<GrantedAuthority> authorities =
               new ArrayList<>();
       userRoleRepository.findByUserUserName(userName).stream().forEach((role) -> {
           authorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
        });
        return authorities;
    }
    
}
