package com.tortillaland.springinfo2021.dao;
import com.tortillaland.springinfo2021.entity.Emprend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmprendsDAO extends JpaRepository<Emprend, Long>{
    
}
