package com.tortillaland.springinfo2021.repository;
import com.tortillaland.springinfo2021.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {   
}