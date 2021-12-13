package com.tortillaland.springinfo2021.dao;

import java.time.LocalDateTime;
import java.util.List;
import com.tortillaland.springinfo2021.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<User, Long> {

    List<User> findByCreatedDateAfter(LocalDateTime localDateTime);

}
