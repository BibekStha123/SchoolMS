/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.repository;

import com.cibt.sms.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bibek
 */
@Repository
public interface SectionRepository extends JpaRepository<Section, Integer>{
    
}
