/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.repository;

import com.cibt.sms.entity.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bibek
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
   
    List<UserRole> findByUserId(int userId);
    List<UserRole> findByUserUserName(String userName);       
}
