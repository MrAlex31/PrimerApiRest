package com.tortillaland.springinfo2021.repository;

import com.tortillaland.springinfo2021.entity.Emprendimieto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimieto, Long> {
}