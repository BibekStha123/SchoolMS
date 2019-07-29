/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.repository;

import com.cibt.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Bibek
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
