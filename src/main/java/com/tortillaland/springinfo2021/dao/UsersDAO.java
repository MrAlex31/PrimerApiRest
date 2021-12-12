package com.tortillaland.springinfo2021.dao;
import com.tortillaland.springinfo2021.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersDAO extends JpaRepository<User, Long> {
    
}
