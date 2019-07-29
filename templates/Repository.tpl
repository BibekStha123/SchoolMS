/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package {{packageName}}repository;

import {{packageName}}entity.{{Entity}};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bibek
 */
@Repository
public interface {{Entity}}Repository extends JpaRepository<{{Entity}}, Integer>{
    
}
