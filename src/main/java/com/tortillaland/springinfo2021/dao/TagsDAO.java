package com.tortillaland.springinfo2021.dao;

import com.tortillaland.springinfo2021.entity.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsDAO extends JpaRepository<Tag, Long> {
    
}
