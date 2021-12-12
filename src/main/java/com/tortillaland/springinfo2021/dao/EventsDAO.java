package com.tortillaland.springinfo2021.dao;
import com.tortillaland.springinfo2021.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventsDAO extends JpaRepository<Event, Long> {

}