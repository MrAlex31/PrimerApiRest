package com.tortillaland.springinfo2021.dao;
import com.tortillaland.springinfo2021.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VotesDAO extends JpaRepository<Vote, Long> {

}